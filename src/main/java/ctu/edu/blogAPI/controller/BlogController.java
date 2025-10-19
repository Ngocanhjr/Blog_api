package ctu.edu.blogAPI.controller;

import ctu.edu.blogAPI.dto.request.CreateBlogRequest;
import ctu.edu.blogAPI.dto.response.BlogDetailsResponse;
import ctu.edu.blogAPI.dto.response.CreateBlogResponse;
import ctu.edu.blogAPI.entities.Blog;
import ctu.edu.blogAPI.service.BlogService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BlogController {

    @Autowired
    BlogService blogService;

    //Get all blogs by userId
    //Sẽ đổi blog thành class dto
    @GetMapping("/users/{userId}/blogs")
    public List<Blog> allBlogsByAuthor(@PathVariable String userId) {
        return blogService.getAllBlogsByAuthor(new ObjectId(userId));
    }

    //Get all blogs for new feed

    //Get details of blog by blogId - done
    @GetMapping("/blogs/{blogId}")
    public ResponseEntity<BlogDetailsResponse> blogDetails(@PathVariable String blogId){
        BlogDetailsResponse response = blogService.getBlogDetails(blogId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //ver1
    //Create blogs
    //Sẽ đổi blog thành class dto
//    @PostMapping("/blogs")
//    public ResponseEntity<Blog> createBlog(@RequestBody CreateBlogRequest request){
//        return new ResponseEntity<Blog>(blogService.initBlog(request),HttpStatus.CREATED);
//    }

    //ver2 - done
    @PostMapping(value = "/blogs", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public ResponseEntity<CreateBlogResponse> createBlog(@ModelAttribute CreateBlogRequest request) {
        CreateBlogResponse response = blogService.initBlog(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
//Dùng @ModelAttribute thay vì @RequestBody để upload file (multipart/form-data).


}
