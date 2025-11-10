package ctu.edu.blogAPI.service;

import javax.management.RuntimeErrorException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ctu.edu.blogAPI.dto.request.AuthenticationRequest;
import ctu.edu.blogAPI.dto.response.AuthenticationResponse;
import ctu.edu.blogAPI.dto.response.LoginUserResponse;
import ctu.edu.blogAPI.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    UserRepository userRepository;

    public AuthenticationResponse authentication(AuthenticationRequest request) {
        var user = userRepository.findByUsername(request.getUsername());
        // .orElseThrow(() -> new RuntimeErrorException(null, "tai khoan ko ton tai"));
        if (user.isEmpty()) {
            // 404 - tài khoản không tồn tại
            return AuthenticationResponse.builder()
                    .authentication(false)
                    .message("Account does not exist")
                    .build();
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean ok = passwordEncoder.matches(request.getPassword(), user.get().getPassword());

        if (!ok) {
            // 401 - mật khẩu sai
            return AuthenticationResponse.builder()
                    .authentication(false)
                    .message("Wrong password")
                    .build();
        }

        return AuthenticationResponse.builder()
                .authentication(true)
                .message("Log in successfully")
                .user(LoginUserResponse.builder()
                        .id(user.get().getId())
                        .username(user.get().getUsername())
                        .build())
                .build();
    }
}
