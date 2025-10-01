package ctu.edu.blogAPI.repository;

import ctu.edu.blogAPI.entities.Blog;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog, ObjectId> {
}
