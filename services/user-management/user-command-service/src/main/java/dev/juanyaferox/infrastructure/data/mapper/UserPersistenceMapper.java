package dev.juanyaferox.infrastructure.data.mapper;

import dev.juanyaferox.domain.model.User;
import dev.juanyaferox.infrastructure.data.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring", uses = {ProfilePersistenceMapper.class})
public interface UserPersistenceMapper {
    UserEntity userToUserEntity(User user);

    User userEntityToUser(UserEntity userEntity);
}
