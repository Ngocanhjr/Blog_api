package ctu.edu.blogAPI.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration

public class CloudinaryConfig {
    private final String CLOUD_NAME = "drwznlrbn";

    private final String API_KEY = "377793341226244";

    private final String API_SECRET = "PIXF1g_uwmc6qvZMuHvt43PqlMM";


    @Bean
    public Cloudinary getCloudinary(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", CLOUD_NAME);
        config.put("api_key", API_KEY);
        config.put("api_secret", API_SECRET);

        return new Cloudinary(config);
    }
}
