# Some dependencies use ing project
- Spring web
- Lombok
- Spring security
- Spring data MongoDB
- Spring Boot DevTools
- Validation
## API endpoint

### Blog

`/api/v1` : prefix

- `/blogs/{authorId}` : get all blogs by authorId (@PathVariable String authorId)
-  `/post`: create new post (@RequestBody CreateBlogRequest request)

**Test upload file**

- `/upload` : upload file (img, video) to cloudinary

## DTO

### CreateBlogRequest

```java
public class CreateBlogRequest {
    private String authorId;
    private String content;
    private List<MultipartFile> imageUrls;
}
```
