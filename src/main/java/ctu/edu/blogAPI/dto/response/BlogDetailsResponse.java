package ctu.edu.blogAPI.dto.response;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogDetailsResponse {
    private String id; //Response trả về sẽ là một chuỗi

    private String userId;

    private String userName;

    private String userAvatarUrl;

    private String content;

    private List<String> imageUrls;

    private Long likeCount;

    private Long commentCount;

    private Long shareCount;

    private Instant createdAt;

}
