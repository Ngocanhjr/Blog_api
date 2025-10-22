package ctu.edu.blogAPI.repository;

import ctu.edu.blogAPI.entities.Blog;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BlogRepository extends MongoRepository<Blog, ObjectId> {
    List<Blog> findByUserId(ObjectId userId);
    List<Blog> findByPublishedTrue();
//    List<Blog> findByUserIdAndPublishedTrue(ObjectId userId);
//    List<Post> findByAuthorInOrderByCreatedAtDesc(List<User> authors);
//    List<Post> findByAuthorOrderByCreatedAtDesc(User author);
//    Page<Post> findAllByOrderByCreatedAtDesc(Pageable pageable);
}
