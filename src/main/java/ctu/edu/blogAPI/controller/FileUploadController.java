package ctu.edu.blogAPI.controller;

import ctu.edu.blogAPI.dto.FileResult;
import ctu.edu.blogAPI.service.impl.CloudinaryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//for api testing purposes only
@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class FileUploadController {
    public final CloudinaryServiceImpl cloudinaryService;
    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        try {
            String imageUrl = cloudinaryService.uploadFile(multipartFile);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("imageUrl", imageUrl);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            Map<String, Object> error = new HashMap<>();
            error.put("success", false);
            error.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @PostMapping("/uploadFiles")
    public ResponseEntity<Map<String, Object>> uploadFiles(@RequestParam(value = "files", required = false) List<MultipartFile> files) throws IOException {
        if (files == null || files.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", "Không có file nào được tải lên"
            ));
        }

        FileResult rs = cloudinaryService.uploadFiles(files);
        Map<String, Object> response = new HashMap<>();
        response.put("success", rs.getFailedFiles().isEmpty());
        response.put("uploaded", rs.getSuccessUrls());
        response.put("failed", rs.getFailedFiles());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Map<String, Object>> deleteFiles(@RequestParam("imgUrl") String imgUrl){
        Map<String, Object> response = new HashMap<>();

        try {
            boolean deleted = cloudinaryService.deleteFile(imgUrl);
            if(deleted){
                response.put("success", true);
                response.put("message", "File deleted successfully");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else{
                response.put("success", false);
                response.put("message", "File not found or already deleted");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }catch (IOException e){
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
