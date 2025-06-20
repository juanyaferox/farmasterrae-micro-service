package dev.juanyaferox.domain.model;

import java.util.UUID;

public record Profile(
        UUID id,
        String type,
        String description
) {

}
