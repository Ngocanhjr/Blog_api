package ctu.edu.blogAPI.dto.request;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
public class BlogCreateRequest {
    private String userId;
//    @Size(max = 10, message = "vượt quá 10 ký tự!!!")
    private String content;

    private boolean published = true;

    @ArraySchema(
            schema = @Schema(type = "array", format = "binary", description = "Danh sách file hình ảnh/blog", implementation = MultipartFile.class)
    )
    private List<MultipartFile> files;

}
