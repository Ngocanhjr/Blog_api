package ctu.edu.blogAPI.service;
import ctu.edu.blogAPI.dto.BlogDTO;
import ctu.edu.blogAPI.dto.request.CreateBlogRequest;
import ctu.edu.blogAPI.dto.response.BlogDetailsResponse;
import ctu.edu.blogAPI.dto.response.CreateBlogResponse;
import ctu.edu.blogAPI.entities.Blog;
import ctu.edu.blogAPI.mapper.BlogMapper;
import ctu.edu.blogAPI.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    private final FileUpload fileUpload;
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
    public CreateBlogResponse initBlog(CreateBlogRequest request) {
//        cần tối ưu vì trùng với controller của FileUpload
        //Fix error NullPointerException when list null
        List<MultipartFile> files = request.getFiles() != null ? request.getFiles() : List.of(); //get file or create empty file
        List<String> successUrls = new ArrayList<>();
        List<String> failedFiles = new ArrayList<>();
        for (MultipartFile file : files) {
            try {
                successUrls.add(fileUpload.uploadFile(file));
            } catch (Exception e) {
                failedFiles.add(file.getOriginalFilename());
            }
        }

        Blog blog = Blog.builder()
                .userId(new ObjectId(request.getUserId())) // convert String -> ObjectId
                .content(request.getContent())
                .imageContentUrls(successUrls)
                .published(request.isPublished())
                .createAt(Instant.now())
                .updateAt(Instant.now())
                .build();

        Blog saved = blogRepository.save(blog);

        return CreateBlogResponse.builder()
                .blogId(saved.getId().toString())
                .successUrls(successUrls)
                .failedFiles(failedFiles)
                .build();
    }

    public List<BlogDTO> getAllBlogsByAuthor(String userId) {
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

    //Get details of blog by blogId
    public BlogDetailsResponse getBlogDetails(String blogId) {
        Blog blog = blogRepository.findById(new ObjectId(blogId)) //return Optional;
                .orElseThrow(() -> new RuntimeException("Blog not found"));
        return BlogMapper.toBlogDetails(blog);
    }
}
