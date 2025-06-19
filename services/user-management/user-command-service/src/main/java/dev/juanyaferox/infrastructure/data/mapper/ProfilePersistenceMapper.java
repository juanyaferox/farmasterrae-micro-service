package dev.juanyaferox.infrastructure.data.mapper;

import dev.juanyaferox.domain.model.Profile;
import dev.juanyaferox.infrastructure.data.entity.ProfileEntity;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ProfilePersistenceMapper {
    Profile profileEntityToProfile(ProfileEntity profileEntity);

    ProfileEntity profileToProfileEntity(Profile profile);
}