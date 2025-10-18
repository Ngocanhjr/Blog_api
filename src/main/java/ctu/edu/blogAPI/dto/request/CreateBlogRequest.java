package ctu.edu.blogAPI.dto.request;


import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
public class CreateBlogRequest {
    private String content;
    private String authorId;
    private List<MultipartFile> imageUrls;
}
