package dev.juanyaferox.user.application.mapper;

import dev.juanyaferox.user.application.dto.CreateUserCommand;
import dev.juanyaferox.user.domain.model.User;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface UserMapper {

    User commandToDomain(CreateUserCommand command);
}
