package ctu.edu.blogAPI.dto.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Data
public class updata {
    String userId;

    MultipartFile file;
}
