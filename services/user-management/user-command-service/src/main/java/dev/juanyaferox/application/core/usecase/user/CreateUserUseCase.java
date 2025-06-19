package dev.juanyaferox.application.core.usecase.user;

import dev.juanyaferox.application.core.providers.UserRepositoryPort;
import dev.juanyaferox.application.dto.CreateUserCommand;
import dev.juanyaferox.application.exception.EmailAlreadyExistsException;
import dev.juanyaferox.application.exception.UserAlreadyExistsException;
import dev.juanyaferox.application.mapper.UserMapper;
import dev.juanyaferox.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepositoryPort userRepositoryPort;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public void execute(CreateUserCommand command) {

        if (userRepositoryPort.findByUsername(command.getUsername()).isPresent())
            throw new UserAlreadyExistsException("Nombre de usuario ya registrado");

        if (userRepositoryPort.findByEmail(command.getEmail()).isPresent())
            throw new EmailAlreadyExistsException("Email ya registrado");

        User user = userMapper.commandToDomain(command)
                .withPassword(passwordEncoder.encode(command.getPassword()));

        userRepositoryPort.save(user);
    }
}
