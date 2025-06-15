package dev.juanyaferox.user.domain.repository;


import dev.juanyaferox.user.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    void save(User user);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    List<User> findAllByProfileType(String type);
}
