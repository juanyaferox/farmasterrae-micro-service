package dev.juanyaferox.infrastructure.api.dto.profile;

public record CreateProfileApiRequest(
        String type,
        String description
) {
}
