package ctu.edu.blogAPI.controller;

import ctu.edu.blogAPI.dto.request.UserCreationRequest;
import ctu.edu.blogAPI.dto.request.UserUpdateRequest;
import ctu.edu.blogAPI.dto.request.UserUpdateRequestPatch;
import ctu.edu.blogAPI.dto.response.UserResponse;
import ctu.edu.blogAPI.dto.response.UserResponsePatch;
import ctu.edu.blogAPI.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController // là một annotation dùng để đánh dấu một lớp là Web Controller, nghĩa là lớp
                // này sẽ nhận các request từ client (HTTP request) và trả về response (HTML,
                // JSON, v.v.).
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/users")
public class UserController {
    UserService userService;

    // tạo user
    @PostMapping("/sign-up")
    UserResponse createUsuer(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    // lấy all các user
    List<UserResponse> getUList() {
        return userService.getUsers();
    }

    // tìm user theo id
    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }

    // tìm user theo id lấy vè username,fullname, dob, userAvatarUrl;
    @GetMapping("patch/{userId}")
    UserResponsePatch getUserPatch(@PathVariable("userId") String userId) {
        return userService.getUserPatch(userId);
    }

    @PutMapping("/{userId}")
    // câp nhập thông tin user dựa trên userId
    UserResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    // câp nhập thông tin user dựa trên userId
    @PatchMapping("/{userId}")
    public UserResponsePatch updateUserPartially(
            @PathVariable String userId,
            @Valid @RequestBody UserUpdateRequestPatch request) {
        return userService.updateUserPartially(userId, request);
    }

    @DeleteMapping("/{userId}")
    // xóa user dựa trên Id
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted.";
    }

    // Xóa avatar của user theo id
    @DeleteMapping("/{id}/avatar")
    public ResponseEntity<String> deleteAvatar(@PathVariable String id) {
        userService.deleteAvatar(id);
        return ResponseEntity.ok("Avatar has been deleted.");
    }

    // Cập nhật avatar cho user theo id (upload file -> Cloudinary -> update DB)
    @PatchMapping("/{id}/avatar")
    public ResponseEntity<UserResponsePatch> updateAvatar(@PathVariable String id, @RequestPart("file") MultipartFile file) throws IOException {

        UserResponsePatch res = userService.updateAvatar(id, file);
        return ResponseEntity.ok(res);
    }

}
