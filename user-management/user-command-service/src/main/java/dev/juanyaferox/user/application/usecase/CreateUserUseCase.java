package dev.juanyaferox.user.application.usecase;

import dev.juanyaferox.user.application.dto.CreateUserCommand;
import dev.juanyaferox.user.infrastructure.data.entity.User;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    public void createUser(CreateUserCommand command) {
        // Lógica para crear un nuevo usuario

        User user = new User();
    }
}
