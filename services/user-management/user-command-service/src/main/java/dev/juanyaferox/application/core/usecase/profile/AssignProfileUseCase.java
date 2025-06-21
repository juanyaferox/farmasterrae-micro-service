package dev.juanyaferox.application.core.usecase.profile;

import dev.juanyaferox.application.core.providers.ProfileRepositoryPort;
import dev.juanyaferox.application.core.providers.UserRepositoryPort;
import dev.juanyaferox.application.core.usecase.profile.dto.AssignProfileCommand;
import dev.juanyaferox.application.exception.ProfileNotFoundException;
import dev.juanyaferox.application.exception.UserNotFoundException;
import dev.juanyaferox.domain.model.Profile;
import dev.juanyaferox.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignProfileUseCase {

    @Autowired
    ProfileRepositoryPort profileRepository;

    @Autowired
    UserRepositoryPort userRepository;

    public void execute(AssignProfileCommand command) {

        Profile profile = profileRepository.findByType(command.getProfileType()).orElseThrow(ProfileNotFoundException::new);
        User user = userRepository.findById(command.getIdUser()).orElseThrow(UserNotFoundException::new)
                .withProfile(profile);
        
        userRepository.save(user);
    }
}
