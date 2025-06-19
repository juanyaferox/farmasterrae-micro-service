package dev.juanyaferox.application.core.usecase.user.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class DeleteUserCommand {
    @NotNull
    UUID id;
}
