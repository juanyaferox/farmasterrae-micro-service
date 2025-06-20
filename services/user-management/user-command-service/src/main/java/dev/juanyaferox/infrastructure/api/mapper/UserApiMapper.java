package dev.juanyaferox.infrastructure.api.mapper;


import dev.juanyaferox.application.core.usecase.user.dto.CreateUserCommand;
import dev.juanyaferox.application.core.usecase.user.dto.UpdateUserCommand;
import dev.juanyaferox.infrastructure.api.dto.user.CreateUserApiRequest;
import dev.juanyaferox.infrastructure.api.dto.user.UpdateUserApiRequest;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface UserApiMapper {

    CreateUserCommand createUserCommandFromCreateUserApiRequest(CreateUserApiRequest request);

    UpdateUserCommand updateUserCommandFromUpdateUserApiRequest(UpdateUserApiRequest request);
}
