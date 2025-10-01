package ctu.edu.blogAPI.dto;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class BlogDTO {
    private ObjectId id;
    private String content;
    private List<String> imageUrls;
    private String authorId;
    private String authorName;
    private String authorAvatar;
    private int likeCount;
    private int commentCount;
    private int shareCount;

    private Instant createdAt;
}
