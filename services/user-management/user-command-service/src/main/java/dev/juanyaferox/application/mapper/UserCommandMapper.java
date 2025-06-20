package dev.juanyaferox.application.mapper;

import dev.juanyaferox.application.core.usecase.user.dto.CreateUserCommand;
import dev.juanyaferox.application.core.usecase.user.dto.UpdateUserCommand;
import dev.juanyaferox.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper (componentModel = "spring")
public interface UserCommandMapper {

    User createCommandToDomain(CreateUserCommand command);

    @Mapping (target = "id", ignore = true)
    void updateCommandToDomain(UpdateUserCommand command, @MappingTarget User user);
}
