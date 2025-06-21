package dev.juanyaferox.application.core.providers;

import dev.juanyaferox.domain.model.Profile;

import java.util.Optional;

public interface ProfileRepositoryPort {

    Optional<Profile> findById(Long id);

    Optional<Profile> findByType(String type);

    Optional<Profile> findByDescription(String description);

    void save(Profile profile);

    void delete(Profile profile);
}
