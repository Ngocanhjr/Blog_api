package ctu.edu.blogAPI.dto.request;


import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBlogRequest {
    @Size(max =  10, message = "vượt quá 10 ký tự!!!")
    private String content;
    private String authorId;
//    private List<MultipartFile> images;
}
