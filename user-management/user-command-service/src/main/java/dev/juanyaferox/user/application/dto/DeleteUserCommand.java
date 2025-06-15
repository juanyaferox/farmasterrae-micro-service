package dev.juanyaferox.user.application.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class DeleteUserCommand {
    @NotNull
    UUID id;
}
