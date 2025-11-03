package ctu.edu.blogAPI.service;

import ctu.edu.blogAPI.dto.FileResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CloudinaryService {
    //upload 1 file
    String uploadFile(MultipartFile multipartFile) throws IOException;

    //upload multi File
    public FileResult uploadFiles(List<MultipartFile> files);

    //delete file
    boolean deleteFile(String file) throws IOException;

    // String uploadAvatar(MultipartFile file, String userId);

    String uploadAvatar(MultipartFile file, String userId) throws IOException;

}
