package dev.juanyaferox.application.mapper;

import dev.juanyaferox.application.core.usecase.user.dto.CreateUserCommand;
import dev.juanyaferox.domain.model.User;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface UserMapper {

    User commandToDomain(CreateUserCommand command);
}
