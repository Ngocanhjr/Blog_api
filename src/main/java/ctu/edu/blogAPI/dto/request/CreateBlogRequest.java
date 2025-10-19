package ctu.edu.blogAPI.dto.request;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Data
@Builder
public class CreateBlogRequest {
    private String userId;
//    @Size(max = 10, message = "vượt quá 10 ký tự!!!")
    private String content;
    private boolean published;
    private List<MultipartFile> files;
}
