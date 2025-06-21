package dev.juanyaferox.infrastructure.api.controller;

import dev.juanyaferox.application.core.usecase.credentials.ChangePasswordUseCase;
import dev.juanyaferox.infrastructure.api.dto.credentials.ChangePasswordApiRequest;
import dev.juanyaferox.infrastructure.api.mapper.CredentialsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/credentials")
@RequiredArgsConstructor
public class CredentialsController {

    private final CredentialsMapper credentialsMapper;
    private final ChangePasswordUseCase changePasswordUseCase;

    @PutMapping
    @ResponseStatus (HttpStatus.ACCEPTED)
    public void changePassword(@RequestBody ChangePasswordApiRequest request) {
        changePasswordUseCase.execute(credentialsMapper.changePasswordCommandFromChangePasswordApiRequest(request));
    }
}
