package ctu.edu.blogAPI.service;

import ctu.edu.blogAPI.entities.Blog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ctu.edu.blogAPI.constants.CloudinaryConstrants.ERROR_DELETE_FILE;
import static ctu.edu.blogAPI.constants.CloudinaryConstrants.SUCCESS_DELETE_FILE;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogSyncService {
    private final CloudinaryService cloudinaryService;

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

    public List<String> deleteAccountAndFile(List<String> files) {
        if (files == null || files.isEmpty()) {
            return List.of();
        }

        List<String> fileResult = new ArrayList<>();

        for (String file : files) {
            try {
                if (cloudinaryService.deleteFile(file)) {
                    log.info(SUCCESS_DELETE_FILE, file);
                }
            } catch (IOException e) {
                fileResult.add(file);
                log.warn(ERROR_DELETE_FILE, file, e.getMessage());
            }
        }

        return fileResult;
    }


//    public List<String> deleteFiles(List<String> files) {
//        if (files == null || files.isEmpty()) {
//            return List.of();
//        }
//
//        return files.parallelStream()
//                .filter(file -> {
//                    try {
//                        boolean deleted = cloudinaryService.deleteFile(file);
//                        if (deleted) {
//                            log.info("Deleted file successfully: {}", file);
//                            return false; // không thêm vào danh sách lỗi
//                        } else {
//                            log.warn("Failed to delete file (Cloudinary returned false): {}", file);
//                            return true; // thêm vào danh sách lỗi
//                        }
//                    } catch (IOException e) {
//                        log.warn("Error deleting file {}: {}", file, e.getMessage());
//                        return true; // thêm vào danh sách lỗi
//                    }
//                })
//                .toList(); // Danh sách các file xóa lỗi
//    }





}
