package ctu.edu.blogAPI.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBlogRequest {
    private String content;
    private String authorId;
//    private List<MultipartFile> images;
}
