package ctu.edu.blogAPI.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import ctu.edu.blogAPI.dto.request.UserCreationRequest;
import ctu.edu.blogAPI.dto.request.UserUpdateRequest; // <-- nhớ import
import ctu.edu.blogAPI.dto.response.UserRespone;
import ctu.edu.blogAPI.entities.User;
import ctu.edu.blogAPI.mapper.UserMapper;
import ctu.edu.blogAPI.repository.UserRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository; // final -> được inject qua constructor
    UserMapper userMapper; // final -> được inject qua constructor

    public User createUser(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("user existed!!!");
        User user = userMapper.toUser(request);
        // mã hóa password
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // lấy user theo id (bạn đang gọi hàm này ở updateUser)
    public UserRespone getUser(String id) {
        return userMapper.toUserRespone(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    // update theo id (dùng MapStruct để bỏ qua null)
    public UserRespone updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findAllById(userId)
                .orElseThrow(() -> new RuntimeErrorException(null, "User not found")); // chỉ ghi đè field != null
        userMapper.updateUser(user, request);
        return userMapper.toUserRespone(userRepository.save(user));
    }

    public void deleteUser(String userId) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User not found"); // hoặc NotFoundException tự định nghĩa
        }
        userRepository.deleteById(userId);
    }
}
