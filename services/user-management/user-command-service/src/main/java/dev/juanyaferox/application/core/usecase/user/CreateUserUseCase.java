package dev.juanyaferox.application.core.usecase.user;

import dev.juanyaferox.application.core.providers.UserRepositoryPort;
import dev.juanyaferox.application.core.usecase.user.dto.CreateUserCommand;
import dev.juanyaferox.application.exception.EmailAlreadyExistsException;
import dev.juanyaferox.application.exception.UserAlreadyExistsException;
import dev.juanyaferox.application.mapper.UserCommandMapper;
import dev.juanyaferox.domain.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    @Autowired
    UserCommandMapper userMapper;

    @Autowired
    UserRepositoryPort userRepositoryPort;

//    @Autowired
//    BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public void execute(CreateUserCommand command) {

        if (userRepositoryPort.findByUsername(command.getUsername()).isPresent())
            throw new UserAlreadyExistsException("Nombre de usuario ya registrado");

        if (userRepositoryPort.findByEmail(command.getEmail()).isPresent())
            throw new EmailAlreadyExistsException("Email ya registrado");

        User user = userMapper.createCommandToDomain(command);
        //.withPassword(passwordEncoder.encode(command.getPassword()));

        userRepositoryPort.save(user);
    }
}
