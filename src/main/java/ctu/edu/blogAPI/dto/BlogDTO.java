package ctu.edu.blogAPI.dto;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class BlogDTO {
    private String id;

    private String userId;

    private String userName;

    private String userAvatarUrl;

    private String content;

    private List<String> imageContentUrls;

    private Long likeCount;

    private Long commentCount;

    private Long shareCount;

    private boolean published = true;

    private Instant createdAt;

    private  Instant updatedAt;
}
