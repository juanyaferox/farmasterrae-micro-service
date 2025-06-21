package dev.juanyaferox.application.core.usecase.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class UpdateUserCommand {
    @NotNull
    UUID id;

    @Size (min = 6, max = 20)
    String username;

    @Size (min = 6, max = 30)
    String password;

    @Size (min = 3, max = 120)
    String fullName;

    @Email (message = "Debe ser un correo")
    @Size (min = 3, max = 100)
    String email;

    @Size (max = 9)
    String phone;

    @Size (max = 100)
    String address;
}
