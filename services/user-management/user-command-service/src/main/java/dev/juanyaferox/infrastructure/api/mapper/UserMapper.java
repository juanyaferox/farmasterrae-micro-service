package dev.juanyaferox.infrastructure.api.mapper;


import dev.juanyaferox.application.core.usecase.user.dto.CreateUserCommand;
import dev.juanyaferox.infrastructure.api.dto.CreateUserApiRequest;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface UserMapper {

    CreateUserCommand createUserCommandFromCreateUserApiRequest(CreateUserApiRequest request);
}
