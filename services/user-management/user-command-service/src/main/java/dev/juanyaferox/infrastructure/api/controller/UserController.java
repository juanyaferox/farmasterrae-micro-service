package dev.juanyaferox.infrastructure.api.controller;

import dev.juanyaferox.application.core.usecase.user.CreateUserUseCase;
import dev.juanyaferox.infrastructure.api.dto.CreateUserApiRequest;
import dev.juanyaferox.infrastructure.api.mapper.UserApiMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/users")
public class UserController {

    @Autowired
    UserApiMapper userMapper;

    @Autowired
    CreateUserUseCase createUserUseCase;

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody CreateUserApiRequest request) {
        var command = userMapper.createUserCommandFromCreateUserApiRequest(request);
        createUserUseCase.execute(command);
    }
}
