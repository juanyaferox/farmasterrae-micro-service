package dev.juanyaferox.application.core.usecase.profile.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AssignProfileCommand {
    UUID idUser;
    String profileType;
}
