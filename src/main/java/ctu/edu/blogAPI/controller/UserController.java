package ctu.edu.blogAPI.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ctu.edu.blogAPI.dto.request.UserCreationRequest;
import ctu.edu.blogAPI.entities.User;
import ctu.edu.blogAPI.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController // là một annotation dùng để đánh dấu một lớp là Web Controller, nghĩa là lớp
                // này sẽ nhận các request từ client (HTTP request) và trả về response (HTML,
                // JSON, v.v.).
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/users")
public class UserController {
    UserService userService;

    @PostMapping
    User createUsuer(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    // lấy all các user
    List<User> getUList() {
        return userService.getUsers();
    }
}
