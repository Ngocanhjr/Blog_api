package ctu.edu.blogAPI.service;

import ctu.edu.blogAPI.dto.request.CreateBlogRequest;
import ctu.edu.blogAPI.entities.Blog;
import ctu.edu.blogAPI.repository.BlogRepository;
import lombok.Builder;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Blog initBlog(CreateBlogRequest request, ObjectId id) {
        Blog  blog = Blog.builder()
                .authorId(id)
                .content(request.getContent())
                .createAt(Instant.now())
                .updateAt(Instant.now())
                .build();


        return blogRepository.save(blog);
    }
}
