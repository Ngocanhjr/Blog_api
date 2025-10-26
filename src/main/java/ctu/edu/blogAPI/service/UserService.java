package ctu.edu.blogAPI.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.http.HttpStatus;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import ctu.edu.blogAPI.dto.request.UserCreationRequest;
import ctu.edu.blogAPI.dto.request.UserUpdateRequest; // <-- nhớ import
import ctu.edu.blogAPI.dto.request.UserUpdateRequestPatch;
import ctu.edu.blogAPI.dto.response.UserResponse;
import ctu.edu.blogAPI.dto.response.UserResponsePatch;
import ctu.edu.blogAPI.entities.User;
import ctu.edu.blogAPI.mapper.UserMapper;
import ctu.edu.blogAPI.repository.UserRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

  UserRepository userRepository; // final -> được inject qua constructor
  UserMapper userMapper; // final -> được inject qua constructor
  private final PasswordEncoder passwordEncoder; // final -> được inject qua constructor

  public UserResponse createUser(UserCreationRequest request) {
    if (userRepository.existsByUsername(request.getUsername()))
      throw new RuntimeException("user existed!!!");
    User user = userMapper.toUser(request);
    // mã hóa password
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    // lưu DB -> nhận về entity đã có id, timestamps...
    User savedUser = userRepository.save(user);

    // entity -> response để trả ra ngoài
    return userMapper.toUserResponse(savedUser);
  }

  public List<UserResponse> getUsers() {
    return userMapper.toResponsesList(userRepository.findAll());
  }

  // lấy user theo id (bạn đang gọi hàm này ở updateUser)
  public UserResponse getUser(String id) {
    return userMapper.toUserResponse(userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found")));
  }
  public UserResponsePatch getUserPatch(String id) {
    return userMapper.toResponsePatch(userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found")));
  }
  // update theo id (dùng MapStruct để bỏ qua null)
  // public UserRespone updateUser(String userId, UserUpdateRequest request) {
  // User user = userRepository.findAllById(userId)
  // .orElseThrow(() -> new RuntimeErrorException(null, "User not found")); // chỉ
  // ghi đè field != null
  // userMapper.updateUser(user, request);
  // return userMapper.toUserRespone(userRepository.save(user));
  // }

  public UserResponse updateUser(String userId, UserUpdateRequest request) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found"));

    // map các field khác, bỏ qua password
    userMapper.updateUser(user, request);

    // nếu có gửi mật khẩu mới -> mã hoá
    if (request.getPassword() != null && !request.getPassword().isBlank()) {
      // tránh double-hash: chỉ set khi khác hiện tại
      if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        user.setPassword(passwordEncoder.encode(request.getPassword())); // dùng biến
      }
    }
    return userMapper.toUserResponse(userRepository.save(user));
  }

  public UserResponsePatch updateUserPartially(String userId, UserUpdateRequestPatch req) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, "User not found", null));

    // if (req.getFullname() != null)
    // user.setFullname(req.getFullname());
    // if (req.getUsername() != null)
    // user.setUsername(req.getUsername());
    // if (req.getUserAvatarUrl() != null)
    // user.setUserAvatarUrl(req.getUserAvatarUrl());
    userMapper.updateUserPartial(user, req); // MapStruct tự bỏ qua field null
    userRepository.save(user);

    return userMapper.toResponsePatch(user); // <— tên hàm đã chuẩn hóa
  }

  public void deleteUser(String userId) {
    if (!userRepository.existsById(userId)) {
      throw new IllegalArgumentException("User not found"); // hoặc NotFoundException tự định nghĩa
    }
    userRepository.deleteById(userId);
  }
}
