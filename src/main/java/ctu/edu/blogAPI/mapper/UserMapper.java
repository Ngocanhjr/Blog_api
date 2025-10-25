package ctu.edu.blogAPI.mapper;

import org.mapstruct.*;

import ctu.edu.blogAPI.dto.request.UserCreationRequest;
import ctu.edu.blogAPI.dto.request.UserUpdateRequest; // <-- nhớ import
import ctu.edu.blogAPI.dto.response.UserRespone;
import ctu.edu.blogAPI.entities.User;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    // Create: DTO -> Entity
    User toUser(UserCreationRequest request);

    // Update: map các field != null từ request vào entity hiện có
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) //Mapper (bỏ qua password + bỏ qua các field null)
    @Mapping(target = "password", ignore = true) // password xử lý tay
    void updateUser(@MappingTarget User user, UserUpdateRequest request);

    // mapping từ UserUpdateRequest vào user
    UserRespone toUserRespone(User user);
}
