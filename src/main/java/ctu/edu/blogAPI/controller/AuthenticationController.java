package ctu.edu.blogAPI.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ctu.edu.blogAPI.dto.request.AuthenticationRequest;
import ctu.edu.blogAPI.dto.response.AuthenticationRespone;
import ctu.edu.blogAPI.entities.User;
import ctu.edu.blogAPI.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public boolean login(@RequestBody @Valid AuthenticationRequest request) {
        return authenticationService.authentication(request);
    }
}
