package ctu.edu.blogAPI.service.impl;

import com.cloudinary.Cloudinary;
import ctu.edu.blogAPI.service.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {
    private final Cloudinary cloudinary;

    @Override
    public String uploadFile(MultipartFile multipartFile) throws IOException {
        return cloudinary.uploader()
                .upload(multipartFile.getBytes(),
                        Map.of("public_id", UUID.randomUUID().toString()))
                .get("url")
                .toString();
    }

    @Override
    public boolean deleteFile(String imgUrl) throws IOException {
        String publicId = extractPublicId(imgUrl);
        Map result = cloudinary.uploader().destroy(publicId, Map.of());
        System.out.println(result.get("result") + "  | " + imgUrl);
        return "ok".equals(result.get("result"));
    }

    private String extractPublicId(String imgUrl) {
        // "http://res.cloudinary.com/drwznlrbn/image/upload/v1761314005/550d5e1b-4626-4942-a095-1c14d7d0758d.jpg"
        String fileName = imgUrl.substring(imgUrl.lastIndexOf("/") + 1);
        System.out.println("Public Id: " + fileName.substring(0, fileName.lastIndexOf(".")));
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    /**
     * @author Le Hieu
     */
    @Override
    public String uploadAvatar(MultipartFile file, String userId) throws IOException {
        // đưa avatar vào thư mục theo user + public_id ổn định (ghi đè)
        String publicId = "avatars/" + userId + "/avatar";
        Map<?, ?> res = cloudinary.uploader().upload(
                file.getBytes(),
                Map.of(
                        "public_id", publicId,
                        "folder", "avatars/" + userId,
                        "overwrite", true,
                        "unique_filename", false,
                        "resource_type", "image"));
        return res.get("secure_url").toString(); // nên dùng secure_url
    }


    

}
