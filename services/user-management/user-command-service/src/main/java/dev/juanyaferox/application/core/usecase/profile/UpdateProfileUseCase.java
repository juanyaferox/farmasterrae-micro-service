package dev.juanyaferox.application.core.usecase.profile;

import dev.juanyaferox.application.core.providers.ProfileRepositoryPort;
import dev.juanyaferox.application.core.usecase.profile.dto.UpdateProfileCommand;
import dev.juanyaferox.application.exception.profile.ProfileDescriptionAlreadyExistsException;
import dev.juanyaferox.application.exception.profile.ProfileTypeAlreadyExistsException;
import dev.juanyaferox.application.mapper.ProfileCommandMapper;
import dev.juanyaferox.domain.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateProfileUseCase {

    @Autowired
    ProfileRepositoryPort profileRepository;

    @Autowired
    ProfileCommandMapper profileCommandMapper;

    public void execute(UpdateProfileCommand command) {
        Profile profile = profileCommandMapper.updateCommandToDomain(command);

        if (!profile.description().equals(command.getDescription())
                && profileRepository.findByDescription(command.getDescription()).isPresent())
            throw new ProfileDescriptionAlreadyExistsException();

        if (!profile.type().equals(command.getType())
                && profileRepository.findByType(command.getType()).isPresent())
            throw new ProfileTypeAlreadyExistsException();

        profileRepository.save(profile);
    }
}
