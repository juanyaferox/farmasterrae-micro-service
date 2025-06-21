package dev.juanyaferox.infrastructure.api.dto.profile;

public record UpdateProfileApiRequest(
        String type,
        String description) {
}
