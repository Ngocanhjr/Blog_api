package ctu.edu.blogAPI.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ctu.edu.blogAPI.dto.request.AuthenticationRequest;
import ctu.edu.blogAPI.dto.response.AuthenticationResponse;
import ctu.edu.blogAPI.service.AuthenticationService;
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

    // @PostMapping("/log-in")
    // ApiResponse<AuthenticationResponse> authenicate(@RequestBody
    // AuthenticationRequest request) {
    // boolean result = authenticationService.authentication(request);
    // return ApiResponse.<AuthenticationResponse>builder()
    // .result(AuthenticationResponse.builder()
    // .authentication(result)
    // .build())
    // .build();

    // }

    // @PostMapping("/login")
    // public boolean login(@RequestBody @Valid AuthenticationRequest request) {
    // return authenticationService.authentication(request);
    // }
    // @PostMapping("/log-in")
    // ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest request) {
    //     var res = authenticationService.authentication(request);
    //     return res.getAuthentication()
    //             ? ResponseEntity.ok(res) // 200 { success:true, user:{id,username} }
    //             : ResponseEntity.status(HttpStatus.SC_UNAUTHORIZED).body(res); // 401 { success:false, user:null }
    // }


    @PostMapping("/log-in")
    AuthenticationResponse loginNoResp(@RequestBody @Valid AuthenticationRequest request) {
        return authenticationService.authentication(request);
    }
    // // API login có lưu session để FE (React) giữ trạng thái đăng nhập
    // @PostMapping("/loginv2")
    // public ApiResponse<Boolean> login(@RequestBody @Valid AuthenticationRequest
    // request, HttpSession session) {
    // boolean result = authenticationService.authentication(request);

    // if (result) {
    // session.setAttribute("user", request.getUsername());
    // }
    // // Không trả thông báo, chỉ trả true/false
    // return ApiResponse.<Boolean>builder()
    // .result(result)
    // .build();
    // }
}