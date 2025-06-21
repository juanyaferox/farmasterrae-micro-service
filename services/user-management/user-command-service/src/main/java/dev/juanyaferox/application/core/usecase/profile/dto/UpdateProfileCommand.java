package dev.juanyaferox.application.core.usecase.profile.dto;

import lombok.Data;

@Data
public class UpdateProfileCommand {
    String type;
    String description;
}
