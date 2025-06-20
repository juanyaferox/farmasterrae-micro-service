package dev.juanyaferox.application.core.usecase.user;

import dev.juanyaferox.application.core.providers.UserRepositoryPort;
import dev.juanyaferox.application.exception.AdminAtLeastOneException;
import dev.juanyaferox.application.exception.UserNotFoundException;
import dev.juanyaferox.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.UUID;

public class DeleteUserUseCase {

    @Autowired
    UserRepositoryPort userRepository;

    public void deleteUserById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        String profileType = user.profile().type();
        if (Objects.equals(profileType, "ADMIN")
                && userRepository.findAllByProfileType(profileType).size() < 2)
            throw new AdminAtLeastOneException();

        userRepository.delete(user);
    }


}
