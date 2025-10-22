package ctu.edu.blogAPI.controller;

import ctu.edu.blogAPI.dto.BlogDTO;
import ctu.edu.blogAPI.dto.request.CreateBlogRequest;
import ctu.edu.blogAPI.dto.response.BlogDetailsResponse;
import ctu.edu.blogAPI.dto.response.CreateBlogResponse;
import ctu.edu.blogAPI.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class BlogController {

    @Autowired
    private BlogService blogService;

    //Get all blog to new feed
    @GetMapping("/soulspaces")
    //Dieu kien blog phai public
    public List<BlogDTO> getAllBlogs(){
        return blogService.getAllPublishedBlogs();
    }

    // Get all blogs by userId
    // Sẽ đổi blog thành class dto
    @GetMapping("/users/{userId}/blogs")
    public List<BlogDTO> getAllBlogsByAuthor(@PathVariable String userId) {
        return blogService.getAllBlogsByAuthor(userId);
    }

    // Get details of blog by blogId - done
    @GetMapping("/blogs/{blogId}")
    public ResponseEntity<BlogDetailsResponse> getBlogDetails(@PathVariable String blogId) {
        BlogDetailsResponse response = blogService.getBlogDetails(blogId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // ver1
    // Create blogs
    // Sẽ đổi blog thành class dto
    // @PostMapping("/blogs")
    // public ResponseEntity<Blog> createBlog(@RequestBody CreateBlogRequest
    // request){
    // return new
    // ResponseEntity<Blog>(blogService.initBlog(request),HttpStatus.CREATED);
    // }

    // ver2 - done
    @PostMapping(value = "/blogs", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CreateBlogResponse> createBlog(@ModelAttribute CreateBlogRequest request) {
//        // ✅ Kiểm tra userId có tồn tại trong database không
//        boolean exists = userRepository.existsById(userId);
//        if (!exists) {
//            throw new ResourceNotFoundException("User not found with id: " + userId);
//        }
        CreateBlogResponse response = blogService.initBlog(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    // Dùng @ModelAttribute thay vì @RequestBody để upload file
    // (multipart/form-data).

//    @DeleteMapping("/blogs/{blogId}")
//    public ResponseEntity<String> deleteBlog(@PathVariable String blogId){
//        //check role before delete
////        if (!blog.getUserId().equals(currentUserId)) {
////            throw new UnauthorizedException("Bạn không có quyền sửa/xoá bài viết này");
////        }
//        blogService.deleteBlog(blogId);
//        return ResponseEntity.ok("Blog deleted successfully");
//    }
}
