package ctu.edu.blogAPI.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ctu.edu.blogAPI.entities.User;

@Repository

public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByUsername(String username);

    /*
     * khi ta khai báo hàm existsByUsername thì Spring tự động qurey kiểm tra sự tồn
     * tại của cái field username này với value username mà mình truyền vào mà mình
     * ko cần implement đoạn code nào
     */
    Optional<User> findAllById(String userId);

    Optional<User> findByUsername(String username);
    Optional<User> findByPassword(String password);
}
