package dev.juanyaferox.application.exception.profile;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.BAD_REQUEST)
public class ProfileDescriptionAlreadyExistsException extends RuntimeException {
    public ProfileDescriptionAlreadyExistsException(String message) {
        super(message);
    }

    public ProfileDescriptionAlreadyExistsException() {
        super("La descripción de perfil ya existe");
    }
}
