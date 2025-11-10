package ctu.edu.blogAPI.mapper;

import ctu.edu.blogAPI.dto.BlogDTO;
import ctu.edu.blogAPI.dto.request.BlogCreateRequest;
import ctu.edu.blogAPI.dto.response.BlogAccessResponse;
import ctu.edu.blogAPI.entities.Blog;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BlogsMapper {

    //ObjectId → String
    @Named("objectIdToString")
    default String objectIdToString(ObjectId objectId) {
        return objectId != null ? objectId.toHexString() : null;
    }
    //String → ObjectId
    @Named("stringToObjectId")
    default ObjectId stringToObjectId(String id) {
        if (id == null || id.isBlank()) return null;
        return new ObjectId(id);
    }

    @Mapping(source = "id", target = "id", qualifiedByName = "objectIdToString")
    @Mapping(source = "userId", target = "userId", qualifiedByName = "objectIdToString")
    @Mapping(source = "author.username", target = "username")
    @Mapping(source = "author.userAvatarUrl", target = "userAvatarUrl")
    BlogDTO toBlogDTO(Blog blog);

    @Mapping(source = "userId", target = "userId", qualifiedByName = "stringToObjectId")
    Blog toBlog(BlogCreateRequest request);

    @Mapping(source = "id", target = "blogId", qualifiedByName = "objectIdToString")
    BlogAccessResponse toBlogAccessResponse(Blog blog);
}
