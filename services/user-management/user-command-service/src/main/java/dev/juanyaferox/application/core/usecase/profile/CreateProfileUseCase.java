package dev.juanyaferox.application.core.usecase.profile;

import dev.juanyaferox.application.core.providers.ProfileRepositoryPort;
import dev.juanyaferox.application.core.usecase.profile.dto.CreateProfileCommand;
import dev.juanyaferox.application.exception.ProfileDescriptionAlreadyExistsException;
import dev.juanyaferox.application.exception.ProfileTypeAlreadyExistsException;
import dev.juanyaferox.application.mapper.ProfileCommandMapper;
import dev.juanyaferox.domain.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateProfileUseCase {

    @Autowired
    ProfileRepositoryPort profileRepository;

    @Autowired
    ProfileCommandMapper profileMapper;

    public void execute(CreateProfileCommand command) {

        if (profileRepository.findByType(command.getType()).isPresent())
            throw new ProfileTypeAlreadyExistsException();

        if (profileRepository.findByDescription(command.getDescription()).isPresent())
            throw new ProfileDescriptionAlreadyExistsException();

        Profile profile = profileMapper.createCommandToDomain(command);
        profileRepository.save(profile);
    }
}
