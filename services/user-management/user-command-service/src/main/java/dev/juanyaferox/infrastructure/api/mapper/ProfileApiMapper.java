package dev.juanyaferox.infrastructure.api.mapper;

import dev.juanyaferox.application.core.usecase.profile.dto.CreateProfileCommand;
import dev.juanyaferox.application.core.usecase.profile.dto.UpdateProfileCommand;
import dev.juanyaferox.infrastructure.api.dto.profile.CreateProfileApiRequest;
import dev.juanyaferox.infrastructure.api.dto.profile.UpdateProfileApiRequest;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ProfileApiMapper {
    CreateProfileCommand createProfileCommandFromCreateProfileApiRequest(CreateProfileApiRequest request);

    UpdateProfileCommand updateProfileCommandFromUpdateProfileApiRequest(UpdateProfileApiRequest request);
}
