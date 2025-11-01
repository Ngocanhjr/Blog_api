package ctu.edu.blogAPI.controller;

import ctu.edu.blogAPI.dto.BlogDTO;
import ctu.edu.blogAPI.dto.request.BlogAccessRequest;
import ctu.edu.blogAPI.dto.request.BlogCreateRequest;
import ctu.edu.blogAPI.dto.request.BlogUpdateRequest;
import ctu.edu.blogAPI.dto.response.BlogAccessResponse;
import ctu.edu.blogAPI.dto.response.BlogCreateResponse;
import ctu.edu.blogAPI.dto.response.BlogUpdateResponse;
import ctu.edu.blogAPI.repository.UserRepository;
import ctu.edu.blogAPI.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class BlogController {

    @Autowired
    private BlogService blogService;
    UserRepository userRepository;

    //Get all blog to new feed - public blog
    @GetMapping("/soulspaces")
    public List<BlogDTO> getAllBlogs() {
        return blogService.getAllPublishedBlogs();
    }

    // Get all blogs by userId
    @GetMapping("/blogs/{userId}/all")
    public List<BlogDTO> getAllBlogsByUser(@PathVariable String userId) {
        return blogService.getAllBlogsByUser(userId);
    }

    //Get all public blog of user by userID
    @GetMapping("/blogs/{userId}/blogs")
    public List<BlogDTO> getAllPublicBlogsByUser(@PathVariable String userId) {
        return blogService.getAllPublicBlogByUserId(userId);
    }

    // Get details of blog by blogId
    @GetMapping("/blogs/{blogId}")
    public ResponseEntity<BlogDTO> getBlogDetails(@PathVariable String blogId) {
        BlogDTO response = blogService.getBlogDetails(blogId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Create new blogs
    @PostMapping(value = "/blogs", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<BlogCreateResponse> createBlog(
            @ModelAttribute BlogCreateRequest request) {
        // Check user already exist in database
        if (!userRepository.existsById(request.getUserId())) {
            throw new RuntimeException("User not found with id: " + request.getUserId());
        }

        BlogCreateResponse response = blogService.initBlog(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //Update visible
    @PatchMapping("blogs/access")
    public ResponseEntity<BlogAccessResponse> updateBlogAccess(@RequestBody BlogAccessRequest request) {
        BlogAccessResponse response = blogService.updateAccess(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/blogs/{blogId}")
    public ResponseEntity<String> deleteBlog(@PathVariable String blogId) {
        //check role before delete
//        if (!blog.getUserId().equals(currentUserId)) {
//            throw new UnauthorizedException("Bạn không có quyền sửa/xoá bài viết này");
//        }
        blogService.deleteBlog(blogId);
        return ResponseEntity.ok("Blog deleted successfully");
    }

    @PatchMapping(value = "blogs-details", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> updatePost(@ModelAttribute BlogUpdateRequest request) {
        try {
            BlogUpdateResponse updated = blogService.updateBlog(request);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

}
