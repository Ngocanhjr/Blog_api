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
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeErrorException(null, "tai khoan ko ton tai"));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean ok = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!ok) {
            return AuthenticationResponse.builder().authentication(false).build();
        }

        return AuthenticationResponse.builder()
                .authentication(true)
                .user(LoginUserResponse.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .build())
                .build();
    }
}
