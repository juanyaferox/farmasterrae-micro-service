package dev.juanyaferox.application.core.usecase.profile.dto;

import lombok.Data;

@Data
public class CreateProfileCommand {
    String type;
    String description;
}
