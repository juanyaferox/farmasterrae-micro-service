package dev.juanyaferox.application.exception.profile;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.BAD_REQUEST)
public class AdminRoleCantBeDeletedException extends RuntimeException {
    public AdminRoleCantBeDeletedException(String message) {
        super(message);
    }

    public AdminRoleCantBeDeletedException() {
        super("El perfil de administrador no puede ser eliminado");
    }
}

