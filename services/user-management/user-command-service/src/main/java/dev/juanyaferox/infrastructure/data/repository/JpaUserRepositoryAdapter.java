package dev.juanyaferox.infrastructure.data.repository;

import dev.juanyaferox.application.core.providers.UserRepositoryPort;
import dev.juanyaferox.domain.model.User;
import dev.juanyaferox.infrastructure.data.entity.UserEntity;
import dev.juanyaferox.infrastructure.data.mapper.UserPersistenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    @Autowired
    JpaUserRepository userRepository;

    @Autowired
    UserPersistenceMapper userPersistenceMapper;

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id).map(userPersistenceMapper::userEntityToUser);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username).map(userPersistenceMapper::userEntityToUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email).map(userPersistenceMapper::userEntityToUser);
    }

    @Override
    public void save(User user) {
        userRepository.save(userPersistenceMapper.userToUserEntity(user));
    }

    @Override
    public void delete(User user) {
        userRepository.save(anonymize(userPersistenceMapper.userToUserEntity(user)));
    }

    @Override
    public List<User> findAllByProfileType(String type) {
        return userRepository.findAllByProfileType(type)
                .stream().map(userPersistenceMapper::userEntityToUser).toList();
    }

    private UserEntity anonymize(UserEntity u) {
        u.setUsername("deleted_" + u.getId());
        u.setEmail("deleted_" + u.getId() + "@example.com");
        u.setFullName(null);
        u.setPhone(null);
        u.setAddress(null);
        u.setDeletedAt(LocalDateTime.now());
        return u;
    }
}
