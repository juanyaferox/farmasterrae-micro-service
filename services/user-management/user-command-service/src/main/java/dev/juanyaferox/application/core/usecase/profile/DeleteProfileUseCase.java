package dev.juanyaferox.application.core.usecase.profile;

import dev.juanyaferox.application.core.providers.ProfileRepositoryPort;
import dev.juanyaferox.application.core.providers.UserRepositoryPort;
import dev.juanyaferox.application.exception.ProfileNotFoundException;
import dev.juanyaferox.domain.model.Profile;
import dev.juanyaferox.domain.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeleteProfileUseCase {

    @Autowired
    ProfileRepositoryPort profileRepository;

    @Autowired
    UserRepositoryPort userRepository;

    @Transactional
    public void execute(Long idToDelete, Long idToAssign) {

        Profile oldProfile = profileRepository.findById(idToDelete).orElseThrow(ProfileNotFoundException::new);

        Profile newProfile = profileRepository.findById(idToAssign).orElseThrow(ProfileNotFoundException::new);

        // Se reasignan los perfiles de los usuarios a uno nuevo
        List<User> users = userRepository.findAllByProfileId(idToDelete).stream().map(
                u -> u.withProfile(newProfile)
        ).toList();
        userRepository.saveAll(users);

        // Se elimina el perfil
        profileRepository.delete(oldProfile);
    }
}
