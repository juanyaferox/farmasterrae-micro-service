package dev.juanyaferox.application.core.usecase.user;

import dev.juanyaferox.application.core.providers.UserRepositoryPort;
import dev.juanyaferox.application.core.usecase.user.dto.UpdateUserCommand;
import dev.juanyaferox.application.exception.EmailAlreadyExistsException;
import dev.juanyaferox.application.exception.UserAlreadyExistsException;
import dev.juanyaferox.application.exception.UserNotFoundException;
import dev.juanyaferox.application.mapper.UserCommandMapper;
import dev.juanyaferox.domain.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UpdateUserUseCase {

    @Autowired
    UserRepositoryPort userRepository;

    @Autowired
    UserCommandMapper userMapper;

    @Transactional
    public void execute(UpdateUserCommand command) throws ResponseStatusException {

        User user = userRepository.findById(command.getId()).orElseThrow(UserNotFoundException::new);

        if (!user.username().equals(command.getUsername())
                && userRepository.findByUsername(command.getUsername()).isPresent())
            throw new UserAlreadyExistsException();

        if (!user.email().equals(command.getEmail())
                && userRepository.findByEmail(command.getEmail()).isPresent())
            throw new EmailAlreadyExistsException();

        userMapper.updateCommandToDomain(command, user);
        userRepository.save(user);
    }

}
