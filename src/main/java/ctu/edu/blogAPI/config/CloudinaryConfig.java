package ctu.edu.blogAPI.config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
//
//@Configuration
//public class CloudinaryConfig {
//
//    @Value("${CLOUD_NAME}")
//    private String CLOUD_NAME;
//
//    @Value("${CLOUD_API_KEY}")
//    private String API_KEY;
//
//    @Value("${CLOUD_API_SECRET}")
//    private String API_SECRET;
//
//    @Bean
//    public Cloudinary cloudinary() {
//        Map<String, String> config = new HashMap<>();
//        config.put("cloud_name", CLOUD_NAME);
//        config.put("api_key", API_KEY);
//        config.put("api_secret", API_SECRET);
//
//        return new Cloudinary(config);
//    }
//}
//

@Configuration
public class CloudinaryConfig {

    private final String cloudName;
    private final String apiKey;
    private final String apiSecret;

    public CloudinaryConfig(
            @Value("${CLOUD_NAME}") String cloudName,
            @Value("${CLOUD_API_KEY}") String apiKey,
            @Value("${CLOUD_API_SECRET}") String apiSecret) {
        this.cloudName = cloudName;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", cloudName);
        config.put("api_key", apiKey);
        config.put("api_secret", apiSecret);
        return new Cloudinary(config);
    }
}
