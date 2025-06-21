package dev.juanyaferox.application.core.usecase.profile;

import dev.juanyaferox.application.core.providers.ProfileRepositoryPort;
import dev.juanyaferox.application.core.providers.UserRepositoryPort;
import dev.juanyaferox.application.exception.profile.ProfileNotFoundException;
import dev.juanyaferox.application.exception.user.UserNotFoundException;
import dev.juanyaferox.domain.model.Profile;
import dev.juanyaferox.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AssignProfileUseCase {

    @Autowired
    ProfileRepositoryPort profileRepository;

    @Autowired
    UserRepositoryPort userRepository;

    public void execute(UUID idUser, Long idProfile) {

        Profile profile = profileRepository.findById(idProfile).orElseThrow(ProfileNotFoundException::new);
        User user = userRepository.findById(idUser).orElseThrow(UserNotFoundException::new)
                .withProfile(profile);

        userRepository.save(user);
    }
}
