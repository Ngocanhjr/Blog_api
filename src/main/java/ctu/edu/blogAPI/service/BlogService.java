package ctu.edu.blogAPI.service;

import ctu.edu.blogAPI.dto.BlogDTO;
import ctu.edu.blogAPI.dto.request.BlogAccessRequest;
import ctu.edu.blogAPI.dto.request.BlogCreateRequest;
import ctu.edu.blogAPI.dto.request.BlogUpdateRequest;
import ctu.edu.blogAPI.dto.response.*;
import ctu.edu.blogAPI.entities.Blog;
import ctu.edu.blogAPI.mapper.BlogMapper;
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
    //ver1
//    public Blog initBlog(CreateBlogRequest request, ObjectId userId) {
//        Blog blog = Blog.builder()
//                .userId(userId)
//                .content(request.getContent())
//                .createAt(Instant.now())
//                .updateAt(Instant.now())
//                .build();
//        return blogRepository.save(blog);
//    }

    //ver2
    public BlogCreateResponse initBlog(BlogCreateRequest request) {
//        cần tối ưu vì trùng với controller của FileUpload
        //Fix error NullPointerException when list null
        List<MultipartFile> files = request.getFiles() != null ? request.getFiles() : List.of(); //get file or create empty file
        List<String> successUrls = new ArrayList<>();
        List<String> failedFiles = new ArrayList<>();
        for (MultipartFile file : files) {
            try {
                successUrls.add(cloudinaryService.uploadFile(file));
            } catch (Exception e) {
                failedFiles.add(file.getOriginalFilename());
            }
        }

        UserResponse currentUser = userService.getUser(request.getUserId());

        Blog blog = Blog.builder()
                .userId(new ObjectId(request.getUserId())) // convert String -> ObjectId
                .userName(currentUser.getUsername())
                .userAvatarUrl(currentUser.getUserAvatarUrl())
                .content(request.getContent())
                .imageContentUrls(successUrls)
                .published(request.isPublished())
                .createAt(Instant.now())
                .updateAt(Instant.now())
                .build();

        Blog saved = blogRepository.save(blog);

        return BlogCreateResponse.builder()
                .blogId(saved.getId().toString())
                .successUrls(successUrls)
                .failedFiles(failedFiles)
                .build();
    }

    // Get all blogs by userId
    public List<BlogDTO> getAllBlogsByUser(String userId) {
        List<Blog> blogs= blogRepository.findByUserId(new ObjectId(userId));
        return blogs.stream()
                .map(BlogMapper::toBlogDTO)
                .toList(); //ánh xạ từng phần tử
    }

    //get all blogs - newfeed
    public List<BlogDTO> getAllPublishedBlogs(){
        List<Blog> blogs = blogRepository.findByPublishedTrue();
        return blogs.stream().map(BlogMapper::toBlogDTO)
                .toList();
    }

    //Get all public blog of user by userID
    public List<BlogDTO> getAllPublicBlogByUserId(String userId) {
        List<Blog> blogs = blogRepository.findByUserIdAndPublishedTrue(new ObjectId(userId));
        return blogs.stream().map(BlogMapper::toBlogDTO).toList();
    }

    //Get details of blog by blogId
    public BlogDetailsResponse getBlogDetails(String blogId) {
        Blog blog = blogRepository.findById(new ObjectId(blogId)) //return Optional;
                .orElseThrow(() -> new RuntimeException("Blog not found"));
        return BlogMapper.toBlogDetails(blog);
    }

    //Update access of blog
    public BlogAccessResponse updateAccess(BlogAccessRequest request){
        Blog blog = blogRepository.findById(new ObjectId(request.getBlogId()))
                .orElseThrow(()->new RuntimeException("Blog not found"));

        blog.setPublished(request.isPublished());
        blog.setUpdateAt(Instant.now());
        blogRepository.save(blog);

        return BlogMapper.toBlogAccessResponse(blog);
    }

    //update content blog
    public BlogUpdateResponse updateDetails(BlogUpdateRequest request){
        Blog blog = blogRepository.findById(new ObjectId(request.getBlogId()))
                .orElseThrow(()-> new RuntimeException("Blog not found"));

        blog.setContent(request.getContent());
        List<MultipartFile> files = request.getNewImages() != null ? List.of(request.getNewImages()) : List.of(); //get file or create empty file
        List<String> successUrls = new ArrayList<>();
        List<String> failedFiles = new ArrayList<>();
        if(files!=null){
            for (MultipartFile file : files) {
                try {
                    successUrls.add(cloudinaryService.uploadFile(file));
                } catch (Exception e) {
                    failedFiles.add(file.getOriginalFilename());
                }
            }
        }
        blog.setUpdateAt(Instant.now());
        blog.setImageContentUrls(successUrls);
        blogRepository.save(blog); // sẽ ghi đè dữ liệu

        return BlogUpdateResponse.builder()
                .blogId(blog.getId().toString())
                .content(blog.getContent())
//                .files(blog.getImageContentUrls())
                .successUrls(successUrls)
                .failedUploadFiles(failedFiles)
                .updateAt(blog.getUpdateAt())
                .build();
    }

    //Delete blog bt blogId
    public void deleteBlog(String blogId) {
        Blog blog = blogRepository.findById(new ObjectId(blogId))
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        List<String> files = blog.getImageContentUrls();

        for(String file: files){
            try {
                if(cloudinaryService.deleteFile(file)){
                    System.out.println("dl");
                }
            } catch (IOException e) {
                System.out.println(file + " can not delete!");
                throw new RuntimeException(e);
            }
        }
        blogRepository.delete(blog);
    }

    public BlogUpdateResponse updateBlog (BlogUpdateRequest request) throws IOException {
        Blog blog = blogRepository.findById(new ObjectId(request.getBlogId()))
                .orElseThrow(()-> new RuntimeException("Blog not found")); //Print result to test

        Blog preBlog = new Blog(blog);

        if(request.getContent()!=null){
            blog.setContent(request.getContent()); // cho phép xóa khi client gửi ""
        }

        if (request.getPublished()!=null){
            blog.setPublished(request.getPublished());
        }


        List<String> failDeleteUrl = new ArrayList<>();
        List<String> failUploadUrl = new ArrayList<>();
        List<String> successUrl = new ArrayList<>();
        //delete old Image
//        Toán tử bạn dùng là || (hoặc) — tức là nếu vế đầu sai (null), Java vẫn sẽ kiểm tra vế sau,
//và lúc này request.getRemoveImagesUrl() đang là null, nên gọi .isEmpty() → lỗi NullPointerException.
//        | Dù vế đầu null, vẫn kiểm tra vế sau → crash | Chỉ kiểm tra vế sau nếu vế đầu khác null |
        if(request.getRemoveImagesUrl()!=null && !request.getRemoveImagesUrl().isEmpty()){
            List<String> removeUrls = new ArrayList<>(request.getRemoveImagesUrl());
//            blog.getImageContentUrls().removeAll(removeUrls);
            for(String url: removeUrls) {
                try {
                    if(cloudinaryService.deleteFile(url)) {
                        blog.getImageContentUrls().remove(url);
                    }
                }catch (IOException e) {
                    failDeleteUrl.add(url);
                }
            }
        }

        //add new image
        List<MultipartFile> newFiles = new ArrayList<>();

        //Nếu request.getNewImages() là null → Arrays.stream(null) sẽ nổ lỗi ngay. "Cannot read the array length because "array" is null"
        if (request.getNewImages() != null && request.getNewImages().length > 0) {
            newFiles = Arrays.stream(request.getNewImages()).toList();
        }

        if(newFiles!=null && !newFiles.isEmpty()) {
            for (MultipartFile file: newFiles){
                try {
                    successUrl.add(cloudinaryService.uploadFile(file));
                } catch (Exception e) {
                    failUploadUrl.add(file.getOriginalFilename());
                }
            }

            List<String> currentImages = blog.getImageContentUrls();
            if (currentImages == null) {
                currentImages = new ArrayList<>();
            }
            currentImages.addAll(successUrl);
            blog.setImageContentUrls(currentImages);
        }


        //ChangeStatus
        if (!preBlog.equals(blog)){
            blog.setUpdateAt(Instant.now());
        }

        blogRepository.save(blog);
        return BlogUpdateResponse.builder()
                .blogId(blog.getId().toString())
                .content(blog.getContent())
                .successUrls(blog.getImageContentUrls())
                .failedDeleteFiles(failDeleteUrl)
                .failedUploadFiles(failUploadUrl)
                .published(blog.isPublished())
                .updateAt(blog.getUpdateAt())
                .build();
    }
}
