package dev.juanyaferox.application.core.usecase.user;

import dev.juanyaferox.application.core.providers.UserRepositoryPort;
import dev.juanyaferox.application.exception.profile.AdminAtLeastOneException;
import dev.juanyaferox.application.exception.user.UserNotFoundException;
import dev.juanyaferox.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteUserUseCase {

    @Autowired
    UserRepositoryPort userRepository;

    public void execute(UUID id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        String profileType = user.profile().type();
        if ("ADMIN".equals(profileType)
                && userRepository.findAllByProfileType(profileType).size() < 2)
            throw new AdminAtLeastOneException();

        userRepository.delete(user);
    }


}
