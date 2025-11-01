package ctu.edu.blogAPI.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

//@Getter
@Builder
@Data
public class BlogAccessRequest {
    private String blogId;

    private boolean published;
}
