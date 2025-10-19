package ctu.edu.blogAPI.dto.response;

import lombok.*;
import org.bson.types.ObjectId;

import java.time.Instant;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogDetailsResponse {
    private String id; //Response trả về sẽ là một chuỗi

    private String userId;

    private String userName;

    private String content;

    private List<String> imageUrls;

    private Long likeCount;

    private Long commentCount;

    private Long shareCount;

    private Instant createdAt;

}
