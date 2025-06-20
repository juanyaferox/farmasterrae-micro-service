package dev.juanyaferox.domain.model;

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
    public User withPassword(String newPassword) {
        return new User(
                this.id,
                this.username,
                this.fullName,
                newPassword,
                this.email,
                this.phone,
                this.address,
                this.deletedAt,
                this.profile
        );
    }

    public User withProfile(Profile profile) {
        return new User(
                this.id,
                this.username,
                this.fullName,
                this.password,
                this.email,
                this.phone,
                this.address,
                this.deletedAt,
                profile
        );
    }
}
