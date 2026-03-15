package ctu.edu.blogAPI.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {
    String uploadFile(MultipartFile multipartFile) throws IOException;

    boolean deleteFile(String file) throws IOException;
}
