package ctu.edu.blogAPI.controller;

import ctu.edu.blogAPI.dto.BlogDTO;
import ctu.edu.blogAPI.dto.request.CreateBlogRequest;
import ctu.edu.blogAPI.entities.Blog;
import ctu.edu.blogAPI.service.BlogService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BlogController {

    @Autowired
    BlogService blogService;


    @GetMapping("/blogs/{authorId}")
    public List<Blog> getAllBlogs(@PathVariable String authorId) {
        ObjectId authorObjId = new ObjectId(authorId);
        return blogService.getAllBlogsByAuthor(authorObjId);
    }

    @PostMapping("/post")
    public ResponseEntity<Blog> createBlog(@RequestBody CreateBlogRequest request){

        ObjectId authorObjId = new ObjectId(request.getAuthorId()); // convert String -> ObjectId
        return new ResponseEntity<Blog>(blogService.initBlog(request,authorObjId),HttpStatus.CREATED);
    }
}
