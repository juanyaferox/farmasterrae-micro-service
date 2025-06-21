package dev.juanyaferox.application.exception.profile;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.BAD_REQUEST)
public class ProfileTypeAlreadyExistsException extends RuntimeException {
    public ProfileTypeAlreadyExistsException(String message) {
        super(message);
    }

    public ProfileTypeAlreadyExistsException() {
        super("El tipo de perfil ya existe");
    }
}
