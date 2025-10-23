package ctu.edu.blogAPI.controller;

import ctu.edu.blogAPI.dto.BlogDTO;
import ctu.edu.blogAPI.dto.request.BlogAccessRequest;
import ctu.edu.blogAPI.dto.request.BlogCreateRequest;
import ctu.edu.blogAPI.dto.request.BlogUpdateRequest;
import ctu.edu.blogAPI.dto.response.BlogAccessResponse;
import ctu.edu.blogAPI.dto.response.BlogDetailsResponse;
import ctu.edu.blogAPI.dto.response.BlogUpdateResponse;
import ctu.edu.blogAPI.dto.response.BlogCreateResponse;
import ctu.edu.blogAPI.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
//@CrossOrigin(origins = "*")
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
    @GetMapping("/blogs/{userId}/all")
    public List<BlogDTO> getAllBlogsByUser(@PathVariable String userId) {
        return blogService.getAllBlogsByUser(userId);
    }

    //Get all public blog of user by userID
    @GetMapping("/blogs/{userId}/blogs")
    public List<BlogDTO>getAllPublicBlogsByUser(@PathVariable String userId){
        return blogService.getAllPublicBlogByUserId(userId);
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
    public ResponseEntity<BlogCreateResponse> createBlog(
            @ModelAttribute BlogCreateRequest request) {
//        // ✅ Kiểm tra userId có tồn tại trong database không
//        boolean exists = userRepository.existsById(userId);
//        if (!exists) {
//            throw new ResourceNotFoundException("User not found with id: " + userId);
//        }
        BlogCreateResponse response = blogService.initBlog(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    // Dùng @ModelAttribute thay vì @RequestBody để upload file
    // (multipart/form-data).

    //Update visible
    @PutMapping("blogs/access")
    public ResponseEntity<BlogAccessResponse> updateBlogAccess(@RequestBody BlogAccessRequest request){
        BlogAccessResponse response = blogService.updateAccess(request);
        return ResponseEntity.ok(response);
    }
    //update content blog
    @PutMapping(value ="/blogs/details", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<BlogUpdateResponse> updateBlogDetails(@ModelAttribute BlogUpdateRequest request){
        BlogUpdateResponse response = blogService.updateDetails(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/blogs/{blogId}")
    public ResponseEntity<String> deleteBlog(@PathVariable String blogId){
        //check role before delete
//        if (!blog.getUserId().equals(currentUserId)) {
//            throw new UnauthorizedException("Bạn không có quyền sửa/xoá bài viết này");
//        }
        blogService.deleteBlog(blogId);
        return ResponseEntity.ok("Blog deleted successfully");
    }
}
