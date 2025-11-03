package ctu.edu.blogAPI.mapper;

import ctu.edu.blogAPI.dto.BlogDTO;
import ctu.edu.blogAPI.dto.request.BlogCreateRequest;
import ctu.edu.blogAPI.dto.response.BlogAccessResponse;
import ctu.edu.blogAPI.entities.Blog;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BlogsMapper {

    default String map(ObjectId objectId) {
        return objectId != null ? objectId.toHexString() : null;
    }

    //String → ObjectId
    default ObjectId map(String id) {
        if (id == null || id.isBlank()) return null;
        return new ObjectId(id);
    }

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userId", target = "userId")
    BlogDTO toBlogDTO(Blog blog);

    @Mapping(source = "userId", target = "userId")
    Blog toBlog(BlogCreateRequest request);

    BlogAccessResponse toBlogAccessResponse(Blog blog);
}
