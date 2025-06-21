package dev.juanyaferox.application.core.usecase.credentials.dto;

import lombok.Data;

@Data
public class ChangePasswordCommand {
    String oldPassword;
    String newPassword;
    String confirmNewPassword;
}
