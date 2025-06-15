package dev.juanyaferox.user.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserCommand {

    @NotBlank (message = "El usuario no puede estar vacío")
    String username;

    @NotBlank
    String fullName;

    @NotBlank (message = "El correo no puede estar vacío")
    @Email (message = "Debe ser un correo")
    String email;

    String phone;

    String address;

    @NotBlank (message = "El usuario debe estar asignado a un tipo")
    String type;
}
