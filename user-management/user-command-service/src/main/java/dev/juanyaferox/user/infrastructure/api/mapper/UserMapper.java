package dev.juanyaferox.user.infrastructure.api.mapper;

import dev.juanyaferox.user.application.dto.CreateUserCommand;
import dev.juanyaferox.user.infrastructure.api.dto.CreateUserApiRequest;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface UserMapper {
    
    CreateUserCommand createUserCommandFromCreateUserApiRequest(CreateUserApiRequest request);
}
