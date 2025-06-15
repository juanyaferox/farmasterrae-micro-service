package dev.juanyaferox.user.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserCommand {

    @NotBlank (message = "El usuario no puede estar vacío")
    @Size (min = 6, max = 20)
    String username;

    @NotBlank
    @Size (min = 6, max = 30)
    String password;

    @NotBlank
    @Size (min = 3, max = 120)
    String fullName;

    @NotBlank (message = "El correo no puede estar vacío")
    @Email (message = "Debe ser un correo")
    @Size (min = 3, max = 100)
    String email;

    @Size (max = 9)
    String phone;

    @Size (max = 100)
    String address;

    @NotBlank (message = "El usuario debe estar asignado a un tipo")
    String type;
}
