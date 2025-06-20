package dev.juanyaferox.infrastructure.api.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record UpdateUserApiRequest(
        UUID id,

        @Size (min = 6, max = 20)
        String username,

        @Size (min = 6, max = 30)
        String password,

        @Size (min = 3, max = 120)
        String fullName,

        @Email (message = "Debe ser un correo")
        @Size (min = 3, max = 100)
        String email,

        @Size (max = 9)
        String phone,

        @Size (max = 100)
        String address,

        String type
) {
}
