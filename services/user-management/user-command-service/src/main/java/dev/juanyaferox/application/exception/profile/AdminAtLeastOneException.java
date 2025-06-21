package dev.juanyaferox.application.exception.profile;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.BAD_REQUEST)
public class AdminAtLeastOneException extends RuntimeException {
    public AdminAtLeastOneException(String message) {
        super(message);
    }

    public AdminAtLeastOneException() {
        super("Tiene que existir al menos un administrador");
    }
}
