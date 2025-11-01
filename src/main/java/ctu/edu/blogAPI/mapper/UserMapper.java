package ctu.edu.blogAPI.mapper;

import java.util.List;

import org.mapstruct.*;

import ctu.edu.blogAPI.dto.request.UserCreationRequest;
import ctu.edu.blogAPI.dto.request.UserUpdateRequest; // <-- nhớ import
import ctu.edu.blogAPI.dto.request.UserUpdateRequestPatch;
import ctu.edu.blogAPI.dto.response.UserResponse;
import ctu.edu.blogAPI.dto.response.UserResponsePatch;
import ctu.edu.blogAPI.entities.User;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    // Create: DTO -> Entity
    User toUser(UserCreationRequest request);

    // Update: map các field != null từ request vào entity hiện có
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) // Mapper (bỏ qua password
                                                                                             // + bỏ qua các field null)
    @Mapping(target = "password", ignore = true) // password xử lý tay
    void updateUser(@MappingTarget User user, UserUpdateRequest request);

    // mapping từ UserUpdateRequest vào user
    UserResponse toUserResponse(User user);

    // Cập nhật một phần: chỉ copy các field != null từ request vào entity
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "password", ignore = true) // không cho PATCH password ở đây
    void updateUserPartial(@MappingTarget User user, UserUpdateRequestPatch request);

    // Entity -> Response (cho PATCH)
    UserResponsePatch toResponsePatch(User user);

    List<UserResponse> toResponsesList(List<User> users);
}
