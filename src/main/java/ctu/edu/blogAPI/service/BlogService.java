package ctu.edu.blogAPI.service;

import ctu.edu.blogAPI.dto.BlogDTO;
import ctu.edu.blogAPI.dto.FileResult;
import ctu.edu.blogAPI.dto.request.BlogAccessRequest;
import ctu.edu.blogAPI.dto.request.BlogCreateRequest;
import ctu.edu.blogAPI.dto.request.BlogUpdateRequest;
import ctu.edu.blogAPI.dto.response.BlogAccessResponse;
import ctu.edu.blogAPI.dto.response.BlogCreateResponse;
import ctu.edu.blogAPI.dto.response.BlogUpdateResponse;
import ctu.edu.blogAPI.dto.response.UserResponse;
import ctu.edu.blogAPI.entities.Blog;
import ctu.edu.blogAPI.mapper.BlogsMapper;
import ctu.edu.blogAPI.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    private final CloudinaryService cloudinaryService;

    private final UserService userService;

    private final BlogsMapper blogsMapper;

    //Create new blog
    public BlogCreateResponse initBlog(BlogCreateRequest request) {
        //Fix error NullPointerException when list null
        List<MultipartFile> files = request.getFiles() != null ? request.getFiles() : List.of(); //get file or create empty file

        FileResult fileResult = uploadFile(files);

        UserResponse currentUser = userService.getUser(request.getUserId());

        Blog blog = blogsMapper.toBlog(request);


        blog.setImageContentUrls(fileResult.getSuccessUrls());
        blog.setUserName(currentUser.getUsername());
        blog.setUserAvatarUrl(currentUser.getUserAvatarUrl());
        blog.setCreatedAt(Instant.now());
        blog.setUpdatedAt(Instant.now());

        Blog saved = blogRepository.save(blog);

        return BlogCreateResponse.builder()
                .blogId(saved.getId().toString())
                .successUrls(saved.getImageContentUrls())
                .failedFiles(fileResult.getFailedFiles())
                .build();
    }

    // Get all blogs by userId
    public List<BlogDTO> getAllBlogsByUser(String userId) {
        if (!ObjectId.isValid(userId)) {
            throw new IllegalArgumentException("Invalid userId: " + userId);
        }

        List<Blog> blogs= blogRepository.findByUserId(new ObjectId(userId));
        return blogs.stream()
                .map(blogsMapper::toBlogDTO)
                .toList(); //ánh xạ từng phần tử
    }

//    get all blogs - newfeed
    public List<BlogDTO> getAllPublishedBlogs(){
        List<Blog> blogs = blogRepository.findByPublishedTrue();
        return blogs.stream().map(blogsMapper::toBlogDTO)
                .toList();
    }

    //Get all public blog of user by userID
    public List<BlogDTO> getAllPublicBlogByUserId(String userId) {
        List<Blog> blogs = blogRepository.findByUserIdAndPublishedTrue(new ObjectId(userId));
        return blogs.stream().map(blogsMapper::toBlogDTO).toList();
    }

    //Get details of blog by blogId
    public BlogDTO getBlogDetails(String blogId) {
        Blog blog = blogRepository.findById(new ObjectId(blogId)) //return Optional;
                .orElseThrow(() -> new RuntimeException("Blog not found"));
        return blogsMapper.toBlogDTO(blog);
    }

    //Update access of blog
    public BlogAccessResponse updateAccess(BlogAccessRequest request){
        Blog blog = blogRepository.findById(new ObjectId(request.getBlogId()))
                .orElseThrow(()->new RuntimeException("Blog not found"));

        blog.setPublished(request.isPublished());
        blog.setUpdatedAt(Instant.now());
        blogRepository.save(blog);

        return blogsMapper.toBlogAccessResponse(blog);
    }

    //Delete blog bt blogId
    public void deleteBlog(String blogId) {
        Blog blog = blogRepository.findById(new ObjectId(blogId))
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        List<String> files = blog.getImageContentUrls() != null ? blog.getImageContentUrls() : List.of();

        if (files != null) {
            List<String> fileResult = deleteFile(files);
            System.out.println(fileResult);
        }

        blogRepository.delete(blog);
    }


    //update content blogs
    public BlogUpdateResponse updateBlog (BlogUpdateRequest request) throws IOException {
        Blog blog = blogRepository.findById(new ObjectId(request.getBlogId()))
                .orElseThrow(()-> new RuntimeException("Blog not found")); //Print result to test

        boolean updated = false; //flag

        if(request.getContent()!=null){
            blog.setContent(request.getContent()); // allow del when client send ""
            updated = true;
        }

        if (request.getPublished()!=null){
            blog.setPublished(request.getPublished());
            updated = true;
        }

        List<String> failDeleteUrl = new ArrayList<>();

        //delete old Image
        // kiểm tra vế sau nếu vế đầu khác null
        if(request.getRemoveImagesUrl()!=null && !request.getRemoveImagesUrl().isEmpty()){
            List<String> removeUrls = new ArrayList<>(request.getRemoveImagesUrl());
            for(String url: removeUrls) {
                try {
                    if(cloudinaryService.deleteFile(url)) {
                        blog.getImageContentUrls().remove(url);
                    }
                }catch (IOException e) {
                    failDeleteUrl.add(url);
                }
            }
            updated = true;
        }

        //add new image
        List<MultipartFile> newFiles = new ArrayList<>();
        FileResult fileResult = new FileResult();

        //Nếu request.getNewImages() là null → Arrays.stream(null) sẽ nổ lỗi ngay. "Cannot read the array length because "array" is null"
        if (request.getNewImages() != null && request.getNewImages().length > 0) {
            newFiles = Arrays.asList(request.getNewImages());
        }

        if(newFiles!=null && !newFiles.isEmpty()) {
            fileResult = uploadFile(newFiles);

            List<String> currentImages = blog.getImageContentUrls();

            if (currentImages == null) {
                currentImages = new ArrayList<>();
            }
            currentImages.addAll(fileResult.getSuccessUrls());

            blog.setImageContentUrls(currentImages);
        }


        //ChangeStatus
        if (updated || !failDeleteUrl.isEmpty() || !fileResult.getSuccessUrls().isEmpty()) {
            blog.setUpdatedAt(Instant.now());
        }

        blogRepository.save(blog);
        return BlogUpdateResponse.builder()
                .blogId(blog.getId().toString())
                .content(blog.getContent())
                .successUrls(blog.getImageContentUrls())
                .failedDeleteFiles(failDeleteUrl)
                .failedUploadFiles(fileResult.getFailedFiles())
                .published(blog.isPublished())
                .updatedAt(blog.getUpdatedAt())
                .build();
    }

    private FileResult uploadFile(List<MultipartFile> files) {
        List<String> successUrls = new ArrayList<>();
        List<String> failedFiles = new ArrayList<>();
        if (files != null) {
            for (MultipartFile file : files) {
                try {
                    successUrls.add(cloudinaryService.uploadFile(file));
                } catch (Exception e) {
                    failedFiles.add(file.getOriginalFilename());
                }
            }
        }
        return new FileResult(successUrls, failedFiles);
    }

    private List<String> deleteFile(List<String> files) {
        List<String> failDeleteUrl = new ArrayList<>();

        for (String file : files) {
            try {
                if (cloudinaryService.deleteFile(file)) {
                    System.out.println("dl");
                }
            } catch (IOException e) {
                System.out.println(file + " can not delete!");
                failDeleteUrl.add(file);
                throw new RuntimeException(e);
            }
        }
        return failDeleteUrl;
    }

    //---
    //update content blog
    public BlogUpdateResponse updateDetails(BlogUpdateRequest request) {
        Blog blog = blogRepository.findById(new ObjectId(request.getBlogId()))
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        blog.setContent(request.getContent());
        List<MultipartFile> files = request.getNewImages() != null ? List.of(request.getNewImages()) : List.of();
        FileResult fileResult = uploadFile(files);
        blog.setUpdatedAt(Instant.now());
        blog.setImageContentUrls(fileResult.getSuccessUrls());
        blogRepository.save(blog); // sẽ ghi đè dữ liệu

        return BlogUpdateResponse.builder()
                .blogId(blog.getId().toString())
                .content(blog.getContent())
                .successUrls(fileResult.getSuccessUrls())
                .failedUploadFiles(fileResult.getFailedFiles())
                .updatedAt(blog.getUpdatedAt())
                .build();
    }
}
