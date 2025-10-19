package ctu.edu.blogAPI.controller;

import ctu.edu.blogAPI.service.impl.CloudinaryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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

    //Nếu 1 file lỗi API trả về lỗi 500 ngay lập tức, reject tất cả f
//    @PostMapping("/uploadFiles")
//    public ResponseEntity<List<String>> uploadFiles(@RequestParam(value = "files",required = false) List<MultipartFile> files) throws IOException{
//        if(files == null || files.isEmpty()){
//            return ResponseEntity.badRequest().body(Collections.emptyList());
//        }
//
//        List<String> uploadUrls = new ArrayList<>();
//        for(MultipartFile file: files){
//            uploadUrls.add(cloudinaryService.uploadFile(file));
//        }
//        return ResponseEntity.ok(uploadUrls);
//    }

    @PostMapping("/uploadFiles")
    public ResponseEntity<Map<String, Object>> uploadFiles(@RequestParam(value = "files", required = false) List<MultipartFile> files) throws IOException {
        if (files == null || files.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", "Không có file nào được tải lên"
            ));
        }

        List<String> successUrls = new ArrayList<>();
        List<String> failedFiles = new ArrayList<>();
        for (MultipartFile file : files) {
            try {
                successUrls.add(cloudinaryService.uploadFile(file));
            } catch (Exception e) {
                failedFiles.add(file.getOriginalFilename());
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("success", failedFiles.isEmpty());
        response.put("uploaded", successUrls);
        response.put("failed", failedFiles);

        return ResponseEntity.ok(response);
    }
}
