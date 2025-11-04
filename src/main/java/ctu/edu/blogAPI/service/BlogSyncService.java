package ctu.edu.blogAPI.service;

import ctu.edu.blogAPI.entities.Blog;
import ctu.edu.blogAPI.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogSyncService {
    private final BlogRepository blogRepository;

    private final MongoTemplate mongoTemplate;

    public Long syncUserAvtToBlog(String userId, String newAvatarUrl) {
        Query query = new Query(Criteria.where("userId").is(new ObjectId(userId)));
        Update update = new Update();

        if (newAvatarUrl != null && !newAvatarUrl.isBlank()) {
            update.set("author.userAvatarUrl", newAvatarUrl);
        }
        return mongoTemplate.updateMulti(query, update, Blog.class).getModifiedCount();
    }

    public Long syncUsernameToBlog(String userId, String newUsername) {
        Query query = new Query(Criteria.where("userId").is(new ObjectId(userId)));
        Update update = new Update();
        if (newUsername != null && !newUsername.isBlank()) {
            update.set("author.username",newUsername);
        }

        return mongoTemplate.updateMulti(query,update,Blog.class).getModifiedCount();
    }
}
