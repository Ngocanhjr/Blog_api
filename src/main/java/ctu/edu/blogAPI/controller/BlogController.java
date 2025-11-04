package ctu.edu.blogAPI.controller;

import ctu.edu.blogAPI.dto.BlogDTO;
import ctu.edu.blogAPI.dto.request.BlogAccessRequest;
import ctu.edu.blogAPI.dto.request.BlogCreateRequest;
import ctu.edu.blogAPI.dto.request.BlogUpdateRequest;
import ctu.edu.blogAPI.dto.response.BlogAccessResponse;
import ctu.edu.blogAPI.dto.response.BlogCreateResponse;
import ctu.edu.blogAPI.dto.response.BlogUpdateResponse;
import ctu.edu.blogAPI.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static ctu.edu.blogAPI.constants.BlogsConstants.*;

@CrossOrigin(origins = "http://localhost:5173")
//@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BlogController {

    private final BlogService blogService;

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
        return ResponseEntity.ok(response);
    }

    //Create new blogs
    @PostMapping(value = "/blogs", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<BlogCreateResponse> createBlog(
            @ModelAttribute BlogCreateRequest request) {
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
        blogService.deleteBlog(blogId);
        return ResponseEntity.ok(SUCCESS_DELETE_BLOG);
    }

    @PatchMapping(value = "blogs-details", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> updatePost(@ModelAttribute BlogUpdateRequest request) throws IOException {
            BlogUpdateResponse updated = blogService.updateBlog(request);
            return ResponseEntity.ok(updated);
    }

}
