package dev.juanyaferox.application.core.providers;


import dev.juanyaferox.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {
    Optional<User> findById(UUID id);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    void save(User user);

    void saveAll(List<User> users);

    void delete(User user);

    List<User> findAllByProfileType(String type);

    List<User> findAllByProfileId(Long id);
}
