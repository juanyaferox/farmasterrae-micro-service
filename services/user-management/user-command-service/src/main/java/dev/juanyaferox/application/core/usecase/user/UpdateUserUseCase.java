package dev.juanyaferox.application.core.usecase.user;

import dev.juanyaferox.application.core.providers.UserRepositoryPort;
import dev.juanyaferox.application.core.usecase.user.dto.UpdateUserCommand;
import dev.juanyaferox.application.exception.EmailAlreadyExistsException;
import dev.juanyaferox.application.exception.UserAlreadyExistsException;
import dev.juanyaferox.application.exception.UserNotFoundException;
import dev.juanyaferox.application.mapper.UserCommandMapper;
import dev.juanyaferox.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

public class UpdateUserUseCase {

    @Autowired
    UserRepositoryPort userRepository;

    @Autowired
    UserCommandMapper userMapper;

    public void updateUserById(UpdateUserCommand command) throws ResponseStatusException {

        User user = userRepository.findById(command.getId()).orElseThrow(UserNotFoundException::new);

        if (!user.username().equals(command.getUsername())
                && userRepository.findByUsername(command.getUsername()).isPresent())
            throw new UserAlreadyExistsException();

        if (!user.email().equals(command.getEmail())
                && userRepository.findByEmail(command.getEmail()).isPresent())
            throw new EmailAlreadyExistsException();

        if (command.getType() == null) {
            command.setType(user.profile().type());
        }
        userMapper.updateCommandToDomain(command, user);
        userRepository.save(user);
    }

}
