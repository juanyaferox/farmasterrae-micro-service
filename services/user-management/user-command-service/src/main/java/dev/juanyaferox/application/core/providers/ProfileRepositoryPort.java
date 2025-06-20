package dev.juanyaferox.application.core.providers;

import dev.juanyaferox.domain.model.Profile;

import java.util.Optional;

public interface ProfileRepositoryPort {

    Optional<Profile> findByType(String type);

    void save(Profile profile);
}
