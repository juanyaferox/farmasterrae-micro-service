package dev.juanyaferox.application.mapper;

import dev.juanyaferox.application.core.usecase.profile.dto.CreateProfileCommand;
import dev.juanyaferox.application.core.usecase.profile.dto.UpdateProfileCommand;
import dev.juanyaferox.domain.model.Profile;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ProfileCommandMapper {

    Profile createCommandToDomain(CreateProfileCommand command);

    Profile updateCommandToDomain(UpdateProfileCommand command);
}
