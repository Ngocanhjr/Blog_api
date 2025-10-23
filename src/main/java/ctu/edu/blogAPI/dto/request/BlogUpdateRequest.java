package ctu.edu.blogAPI.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

//@Getter
@Builder
@Data
public class BlogUpdateRequest {
    private String blogId;

    private String content;

    private List<MultipartFile> files;
}
