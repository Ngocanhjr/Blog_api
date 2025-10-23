package ctu.edu.blogAPI.mapper;

import ctu.edu.blogAPI.dto.BlogDTO;
import ctu.edu.blogAPI.dto.response.BlogAccessResponse;
import ctu.edu.blogAPI.dto.response.BlogDetailsResponse;
import ctu.edu.blogAPI.dto.response.BlogUpdateResponse;
import ctu.edu.blogAPI.entities.Blog;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Builder
public class BlogMapper {
    public static BlogDetailsResponse toBlogDetails(Blog blog) {
        if (blog == null) {
            return null;
        }

        return BlogDetailsResponse.builder()
                .id(blog.getId().toString())
//                .userId(blog.getUserId().toString())
                .userId(blog.getUserId() != null ? blog.getUserId().toString() : null)
                .userName(blog.getUserName())
//                .userName(blog.getUserName() != null ? blog.getAuthor().getUsername() : null)
                .content(blog.getContent())
                .imageUrls(blog.getImageContentUrls())
                .likeCount(blog.getLikesCount())
                .commentCount(blog.getCommentsCount())
                .shareCount(blog.getSharesCount())
                .createdAt(blog.getCreateAt() != null ? Instant.parse(blog.getCreateAt().toString()) : null)
                .build();
    }

    public static BlogDTO toBlogDTO(Blog blog){
        if (blog == null) {
            return null;
        }

        return BlogDTO.builder()
                .id(blog.getId().toString())
                .userId(blog.getUserId() != null ? blog.getUserId().toString() : null)
                .userName(blog.getUserName())
                .userAvatarUrl(blog.getUserAvatarUrl())
                .content(blog.getContent())
                .imageContentUrls(blog.getImageContentUrls())
                .likeCount(blog.getLikesCount())
                .commentCount(blog.getCommentsCount())
                .shareCount(blog.getSharesCount())
                .published(blog.isPublished())
                .createdAt(blog.getCreateAt() != null ? Instant.parse(blog.getCreateAt().toString()) : null)
                .updateAt(blog.getUpdateAt()!=null ? Instant.parse(blog.getUpdateAt().toString()): null)
                .build();
    }

    public static BlogAccessResponse toBlogAccessResponse(Blog blog) {
        if (blog == null)
            return null;
        return BlogAccessResponse.builder()
                .blogId(blog.getId().toString())
                .published(blog.isPublished())
                .updateAt(blog.getUpdateAt())
                .build();
    }

}
