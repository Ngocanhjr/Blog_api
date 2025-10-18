package ctu.edu.blogAPI.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "blogs")
public class Blog {
    @Id
    private ObjectId id;

    private ObjectId userId;

//    @DBRef
//    private User author;

    private String content;

    private Long likesCount = 0L; //tránh null khi insert.

    private Long commentsCount = 0L;

    private Long sharesCount = 0L;

    private boolean isPublished = true;

    @CreatedDate
    private Instant createAt;

    @LastModifiedDate
    private  Instant updateAt;

    //Người repost là duy nhất
    private Set<ObjectId> repostOf;

    private Set<ObjectId> likers;

    private Set<ObjectId> sharers;

    //vì ảnh có thể trùng, có thứ tự
    private List<String> imgUrls;

    //List Comment
}
