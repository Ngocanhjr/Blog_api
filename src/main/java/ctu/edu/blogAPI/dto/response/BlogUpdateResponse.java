package ctu.edu.blogAPI.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BlogUpdateResponse {
    private String blogId;

    private String content;

    private List<String> successUrls;
    private List<String> failedFiles;

    private Instant updateAt;
}
