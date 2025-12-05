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
import ctu.edu.blogAPI.entities.UserInfo;
import ctu.edu.blogAPI.exception.BlogNotFoundException;
import ctu.edu.blogAPI.mapper.BlogsMapper;
import ctu.edu.blogAPI.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ctu.edu.blogAPI.constants.BlogsConstants.*;
import static ctu.edu.blogAPI.constants.CloudinaryConstrants.*;
import static ctu.edu.blogAPI.constants.UserConstants.*;

@Service
@RequiredArgsConstructor
@Slf4j
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

        //Lấy thông tin user hiện tại
        UserResponse currentUser = userService.getUser(request.getUserId());

        // Tạo đối tượng UserInfo và nhúng vào
        UserInfo userInfo = UserInfo.builder()
                .username(currentUser.getUsername())
                .userAvatarUrl(currentUser.getUserAvatarUrl())
                .build();

        Blog blog = blogsMapper.toBlog(request);

        blog.setUserId(new ObjectId(currentUser.getId()));
        blog.setAuthor(userInfo);
        blog.setCommentsCount(0L);
        blog.setLikesCount(0L);
        blog.setSharesCount(0L);
        blog.setImageContentUrls(fileResult.getSuccessUrls());
        blog.setCreatedAt(Instant.now());
        blog.setUpdatedAt(Instant.now());

        //Tái kiểm tra
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
            throw new IllegalArgumentException(ERROR_INVALID_USER + ": " + userId);
        }

        List<Blog> blogs= blogRepository.findByUserId(new ObjectId(userId));
        return blogs.stream()
                .map(blogsMapper::toBlogDTO)
                .toList(); //ánh xạ từng phần tử
    }

    //get all blogs - newfeed
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
        if (!ObjectId.isValid(blogId)) {
            throw new IllegalArgumentException(ERROR_INVALID_BLOG + ": " + blogId);
        }

        Blog blog = blogRepository.findById(new ObjectId(blogId)) //return Optional;
                .orElseThrow(() -> new BlogNotFoundException(ERROR_BLOG_NOT_FOUND));
        return blogsMapper.toBlogDTO(blog);
    }

    //Update access of blog
    public BlogAccessResponse updateAccess(BlogAccessRequest request){
        Blog blog = blogRepository.findById(new ObjectId(request.getBlogId()))
                .orElseThrow(() -> new BlogNotFoundException(ERROR_BLOG_NOT_FOUND));

        blog.setPublished(request.isPublished());
        blog.setUpdatedAt(Instant.now());
        blogRepository.save(blog);

        return blogsMapper.toBlogAccessResponse(blog);
    }

    //Delete blog bt blogId
    @Transactional
    public void deleteBlog(String blogId) {
        Blog blog = blogRepository.findById(new ObjectId(blogId))
                .orElseThrow(() -> new BlogNotFoundException(ERROR_BLOG_NOT_FOUND));

        List<String> files = blog.getImageContentUrls() != null ? blog.getImageContentUrls() : List.of();

        if (!files.isEmpty()) {
            List<String> fileResult = deleteFile(files);
            if (!fileResult.isEmpty()) { //Nếu có file xóa lỗi
                log.warn(ERROR_DELETE_FILE_IN_BLOGS,
                        fileResult.size(), blogId, fileResult);
            }
        }

        blogRepository.delete(blog);

    }


    //update content blogs
    public BlogUpdateResponse updateBlog (BlogUpdateRequest request) throws IOException {
        Blog blog = blogRepository.findById(new ObjectId(request.getBlogId()))
                .orElseThrow(() -> new BlogNotFoundException(ERROR_BLOG_NOT_FOUND)); //Print result to test

        boolean updated = false; //flag

        if(request.getContent()!=null){
            blog.setContent(request.getContent()); // allow del when client send ""
            updated = true;
        }

        if (request.getPublished()!=null){
            blog.setPublished(request.getPublished());
            updated = true;
        }

        //Danh sach hình ảnh hiện tại
        List<String> currentImages = blog.getImageContentUrls() != null ? new ArrayList<>(blog.getImageContentUrls()) : new ArrayList<>();
        List<String> failDeleteUrl = new ArrayList<>();

        //delete old Image
        // kiểm tra vế sau nếu vế đầu khác null
        if(request.getRemoveImagesUrl()!=null && !request.getRemoveImagesUrl().isEmpty()){
            List<String> removeUrls = new ArrayList<>(request.getRemoveImagesUrl());
            //Xoá khỏi CSDL
            currentImages.removeAll(removeUrls);

            //Xoá trên cloud
            failDeleteUrl = deleteFile(removeUrls);
            updated = true;
        }

        //add new image
        FileResult fileResult = new FileResult();

        if (request.getNewImages() != null && request.getNewImages().length > 0) {
            //Lọc nội dung image
            List<MultipartFile> newFiles = Arrays.stream(request.getNewImages())
                    .filter(f -> f != null && f.isEmpty())
                    .collect(Collectors.toList());
            newFiles = Arrays.asList(request.getNewImages());

            if (!newFiles.isEmpty()) {
                fileResult = uploadFile(newFiles); //upload các file hop lệ
                currentImages.addAll(fileResult.getSuccessUrls()); //Them url file vao csdl
                updated = true;
            }
        }

        blog.setImageContentUrls(currentImages);

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

        if (files == null || files.isEmpty()) {
            return new FileResult(successUrls, failedFiles);
        }

            for (MultipartFile file : files) {
                if (file == null || file.isEmpty()) continue;
                try {
                    successUrls.add(cloudinaryService.uploadFile(file));
                } catch (Exception e) {
                    log.error(ERROR_UPLOAD_FILE, file.getOriginalFilename(), e);
                    failedFiles.add(file.getOriginalFilename());
                }
            }

        return new FileResult(successUrls, failedFiles);
    }

    private List<String> deleteFile(List<String> files) {
        List<String> failDeleteUrl = new ArrayList<>();

        for (String file : files) {
            try {
                if (cloudinaryService.deleteFile(file)) {
                    log.info(SUCCESS_DELETE_FILE, file);
                }
            } catch (IOException e) {
                failDeleteUrl.add(file);
                log.warn(ERROR_DELETE_FILE, file, e.getMessage());
            }
        }
        return failDeleteUrl;
    }

    //---Xem thêm tham khảo lỗi logic này
    //update content blog
//    public BlogUpdateResponse updateDetails(BlogUpdateRequest request) {
//        Blog blog = blogRepository.findById(new ObjectId(request.getBlogId()))
//                .orElseThrow(() -> new RuntimeException("Blog not found"));
//
//        blog.setContent(request.getContent());
//        List<MultipartFile> files = request.getNewImages() != null ? List.of(request.getNewImages()) : List.of();
//        FileResult fileResult = uploadFile(files);
//        blog.setUpdatedAt(Instant.now());
//        blog.setImageContentUrls(fileResult.getSuccessUrls());
//        blogRepository.save(blog); // sẽ ghi đè dữ liệu
//
//        return BlogUpdateResponse.builder()
//                .blogId(blog.getId().toString())
//                .content(blog.getContent())
//                .successUrls(fileResult.getSuccessUrls())
//                .failedUploadFiles(fileResult.getFailedFiles())
//                .updatedAt(blog.getUpdatedAt())
//                .build();
//    }
}
