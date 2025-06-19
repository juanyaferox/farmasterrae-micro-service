package dev.juanyaferox.application.core.providers;


import dev.juanyaferox.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    void save(User user);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    List<User> findAllByProfileType(String type);
}
