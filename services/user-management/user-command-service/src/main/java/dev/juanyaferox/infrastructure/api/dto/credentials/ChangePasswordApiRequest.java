package dev.juanyaferox.infrastructure.api.dto.credentials;

public record ChangePasswordApiRequest(
        String oldPassword,
        String newPassword,
        String confirmNewPassword
) {
}
