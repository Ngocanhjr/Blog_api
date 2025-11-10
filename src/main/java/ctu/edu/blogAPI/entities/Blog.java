package ctu.edu.blogAPI.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document(collection = "blogs") //Dùng cho MongoDB để ánh xạ lớp Java thành tài liệu (document) trong collection MongoDB. - xem nó như là 1 cái table trong DBMS
public class Blog {
    @Id
    private ObjectId id;

    private ObjectId userId;

    private UserInfo author;

    private String content;

    //vì ảnh có thể trùng, có thứ tự
    private List<String> imageContentUrls;

    private Long likesCount = 0L; //tránh null khi insert.

    private Long commentsCount = 0L;

    private Long sharesCount = 0L;

    private boolean published = true;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private  Instant updatedAt;

    //Người repost là duy nhất
    private Set<ObjectId> repostOf;

    private Set<ObjectId> likers;

    private Set<ObjectId> sharers;

    public Blog(Blog blog) {
    }

    //List Comment
}
