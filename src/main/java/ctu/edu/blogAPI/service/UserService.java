package ctu.edu.blogAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import ctu.edu.blogAPI.dto.request.UserCreationRequest;
import ctu.edu.blogAPI.dto.request.UserUpdateRequest;   // <-- nhớ import
import ctu.edu.blogAPI.entities.User;
import ctu.edu.blogAPI.mapper.UserMapper;
import ctu.edu.blogAPI.repository.UserRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;   // final -> được inject qua constructor
    UserMapper userMapper;           // final -> được inject qua constructor

    public User createUser(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("user existed!!!");
        User user = userMapper.toUser(request);
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // lấy user theo id (bạn đang gọi hàm này ở updateUser)
    public User getUser(String id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // update theo id (dùng MapStruct để bỏ qua null)
    public User updateUser(String userId, UserUpdateRequest request){
        User user = getUser(userId);
        userMapper.updateUser(user, request);   // chỉ ghi đè field != null
        return userRepository.save(user);
    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }
}
