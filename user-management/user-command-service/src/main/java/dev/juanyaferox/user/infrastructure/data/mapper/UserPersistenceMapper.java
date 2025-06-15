package dev.juanyaferox.user.infrastructure.data.mapper;

import dev.juanyaferox.user.domain.model.User;
import dev.juanyaferox.user.infrastructure.data.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface UserPersistenceMapper {
    UserEntity userToUserEntity(User user);

    User userEntityToUser(UserEntity userEntity);
}
