package dev.juanyaferox.infrastructure.api.controller;

import dev.juanyaferox.application.core.usecase.user.CreateUserUseCase;
import dev.juanyaferox.application.core.usecase.user.DeleteUserUseCase;
import dev.juanyaferox.application.core.usecase.user.UpdateUserUseCase;
import dev.juanyaferox.infrastructure.api.dto.user.CreateUserApiRequest;
import dev.juanyaferox.infrastructure.api.dto.user.UpdateUserApiRequest;
import dev.juanyaferox.infrastructure.api.mapper.UserApiMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping ("/api/user")
public class UserController {

    @Autowired
    UserApiMapper userMapper;

    @Autowired
    CreateUserUseCase createUserUseCase;

    @Autowired
    UpdateUserUseCase updateUserUseCase;

    @Autowired
    DeleteUserUseCase deleteUserUseCase;


    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody CreateUserApiRequest request) {
        var command = userMapper.createUserCommandFromCreateUserApiRequest(request);
        createUserUseCase.execute(command);
    }

    @PutMapping
    @ResponseStatus (HttpStatus.ACCEPTED)
    public void updateUser(@Valid @RequestBody UpdateUserApiRequest request) {
        var command = userMapper.updateUserCommandFromUpdateUserApiRequest(request);
        updateUserUseCase.updateUserById(command);
    }

    @DeleteMapping
    @ResponseStatus (HttpStatus.ACCEPTED)
    public void deleteUser(@RequestParam UUID id) {
        deleteUserUseCase.deleteUserById(id);
    }
}
