package dev.juanyaferox.application.core.usecase.credentials;

import dev.juanyaferox.application.core.usecase.credentials.dto.ChangePasswordCommand;
import org.apache.commons.lang.ObjectUtils;

public class ChangePasswordUseCase {
    public void execute(ChangePasswordCommand command) {

        String oldPassword = command.getOldPassword();
        String newPassword = command.getNewPassword();
        String confirmNewPassword = command.getConfirmNewPassword();

        if (!ObjectUtils.equals(newPassword, confirmNewPassword))
            throw new RuntimeException();

        if (ObjectUtils.equals(oldPassword, newPassword))
            throw new RuntimeException();

        // hashear y guardar las contraseñas
    }
}
