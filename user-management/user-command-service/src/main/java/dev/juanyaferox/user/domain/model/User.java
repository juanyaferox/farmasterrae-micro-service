package dev.juanyaferox.user.domain.model;

import dev.juanyaferox.profile.infrastructure.data.entity.Profile;

import java.time.LocalDateTime;
import java.util.UUID;

public record User(
        UUID id,
        String username,
        String fullName,
        String password,
        String email,
        String phone,
        String address,
        LocalDateTime deletedAt,
        Profile profile
) {
}
