package dev.juanyaferox.user.domain.repository;


import dev.juanyaferox.user.infrastructure.data.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    List<User> findAllByProfileType(String type);
}
