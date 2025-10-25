package ctu.edu.blogAPI.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ctu.edu.blogAPI.dto.request.AuthenticationRequest;
import ctu.edu.blogAPI.dto.response.ApiResponse;
import ctu.edu.blogAPI.dto.response.AuthenticationRespone;
import ctu.edu.blogAPI.service.AuthenticationService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    ApiResponse<AuthenticationRespone> authenicate(@RequestBody AuthenticationRequest request) {
        boolean result = authenticationService.authentication(request);
        return ApiResponse.<AuthenticationRespone>builder()
                .result(AuthenticationRespone.builder()
                        .authentication(result)
                        .build())
                .build();

    }

    @PostMapping("/login")
    public boolean login(@RequestBody @Valid AuthenticationRequest request) {
        return authenticationService.authentication(request);
    }

        // API login có lưu session để FE (React) giữ trạng thái đăng nhập
    @PostMapping("/loginv2")
    public ApiResponse<Boolean> login(@RequestBody @Valid AuthenticationRequest request, HttpSession session) {
        boolean result = authenticationService.authentication(request);

        if (result) {
            session.setAttribute("user", request.getUsername());
        }
        // Không trả thông báo, chỉ trả true/false
        return ApiResponse.<Boolean>builder()
                .result(result)
                .build();
    }
}