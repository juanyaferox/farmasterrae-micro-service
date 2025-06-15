package dev.juanyaferox.user.application.usecase;

import dev.juanyaferox.user.application.dto.CreateUserCommand;
import dev.juanyaferox.user.application.mapper.UserMapper;
import dev.juanyaferox.user.domain.model.User;
import dev.juanyaferox.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CreateUserUseCase {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;


    public void execute(CreateUserCommand command) {

        if (userRepository.findByUsername(command.getUsername()).isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario ya registrado");

        if (userRepository.findByEmail(command.getEmail()).isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email ya registrado");
        
        User user = userMapper.commandToDomain(command)
                .withPassword(passwordEncoder.encode(command.getPassword()));
        userRepository.save(user);
    }
}
