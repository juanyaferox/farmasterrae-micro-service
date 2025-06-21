package dev.juanyaferox.application.exception.profile;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.BAD_REQUEST)
public class ClientRoleCantBeDeletedException extends RuntimeException {
    public ClientRoleCantBeDeletedException(String message) {
        super(message);
    }

    public ClientRoleCantBeDeletedException() {
        super("El perfil de cliente no puede ser eliminado");
    }
}

