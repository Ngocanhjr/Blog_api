package ctu.edu.blogAPI.service;

import ctu.edu.blogAPI.dto.request.UserCreationRequest;
import ctu.edu.blogAPI.dto.request.UserUpdateRequest;
import ctu.edu.blogAPI.dto.request.UserUpdateRequestPatch;
import ctu.edu.blogAPI.dto.response.UserResponse;
import ctu.edu.blogAPI.dto.response.UserResponsePatch;
import ctu.edu.blogAPI.entities.User;
import ctu.edu.blogAPI.mapper.UserMapper;
import ctu.edu.blogAPI.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

  UserRepository userRepository; // final -> được inject qua constructor
  UserMapper userMapper; // final -> được inject qua constructor
  private final PasswordEncoder passwordEncoder; // final -> được inject qua constructor
  CloudinaryService cloudinaryService; // <-- thêm dependency này (tạo bean như bạn đã cấu hình Cloudinary)
  SyncUserAndBlog syncUserAndBlog;

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

  // lấy user theo id (bạn đang gọi hàm này ở updateUser)
  public UserResponse getUser(String id) {
    return userMapper.toUserResponse(userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found")));
  }

  public List<UserResponse> getUsers() {
    return userMapper.toResponsesList(userRepository.findAll());
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
    Long updateUsername = syncUserAndBlog.syncUsernameToBlog(userId,req.getUsername());
    System.out.println(updateUsername + " username");
    return userMapper.toResponsePatch(user); // <— tên hàm đã chuẩn hóa
  }

  public void deleteUser(String userId) {
    if (!userRepository.existsById(userId)) {
      throw new IllegalArgumentException("User not found"); // hoặc NotFoundException tự định nghĩa
    }
    userRepository.deleteById(userId);
  }

  //Upload file avatar lên Cloudinary, nhận secure_url và lưu vào user.userAvatarUrl
  // Giống cách NA lưu Blog.imgUrls (Cloudinary URL).

  public UserResponsePatch getUserPatch(String id) {
    return userMapper.toResponsePatch(userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found")));
  }


  //  //Nếu avatar đã có URL sẵn (không upload Cloudinary).
  // public UserResponsePatch updateAvatarUrl(String userId, String avatarUrl) {
  //   if (avatarUrl == null || avatarUrl.isBlank()) {
  //     throw new ResponseStatusException(HttpStatus.SC_BAD_REQUEST, "avatarUrl is required", null);
  //   }

  //   User user = userRepository.findById(userId)
  //       .orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, "User not found", null));

  //   user.setUserAvatarUrl(avatarUrl);
  //   userRepository.save(user);

  //   return userMapper.toResponsePatch(user);
  // }

  public UserResponsePatch updateAvatar(String userId, MultipartFile file) throws IOException {
    if (file == null || file.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.SC_BAD_REQUEST, "Avatar file is empty", null);
    }

    User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, "User not found", null));

    // folder đề xuất: avatars/{userId}; có thể force public_id cố định để ghi đè
    String folder = "avatars/" + userId;
    String url = cloudinaryService.uploadAvatar(file, userId);
    user.setUserAvatarUrl(url);
    userRepository.save(user);

    //by Rhna: khi nao cap nhap avt thi goi ham nay
    Long avtUpdate = syncUserAndBlog.syncUserAvtToBlog(userId, url);

    System.out.println(avtUpdate + " Rhna");
    return UserResponsePatch.builder()
            .username(user.getUsername())
            .fullname(user.getFullname())
            .dob(user.getDob())
            .userAvatarUrl(user.getUserAvatarUrl())
            .build();
  }
}
