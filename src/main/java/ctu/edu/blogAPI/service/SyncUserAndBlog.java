package ctu.edu.blogAPI.service;

import ctu.edu.blogAPI.entities.Blog;
import ctu.edu.blogAPI.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SyncUserAndBlog {
    private final BlogRepository blogRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    public Long syncUserAvtToBlog(String userId, String newAvatarUrl) {
        Query query = new Query(Criteria.where("userId").is(new ObjectId(userId)));
        Update update = new Update();

        if (newAvatarUrl != null && !newAvatarUrl.isBlank()) {

            update.set("userAvatarUrl", newAvatarUrl);

        }
        return mongoTemplate.updateMulti(query, update, Blog.class).getModifiedCount();
    }

    public Long syncUsernameToBlog(String userId, String newUsername) {
        Query query = new Query(Criteria.where("userId").is(new ObjectId(userId)));
        Update update = new Update();
        if (newUsername != null && !newUsername.isBlank()) {
            update.set("userName",newUsername);
        }

        return mongoTemplate.updateMulti(query,update,Blog.class).getModifiedCount();
    }
}
