package dev.juanyaferox.user.infrastructure.data.repository;

import dev.juanyaferox.user.domain.model.User;
import dev.juanyaferox.user.domain.repository.UserRepository;
import dev.juanyaferox.user.infrastructure.data.mapper.UserPersistenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    JpaUserRepository userRepository;
    
    @Autowired
    UserPersistenceMapper userPersistenceMapper;

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
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public List<User> findAllByProfileType(String type) {
        return userRepository.findAllByProfileType(type)
                .stream().map(userPersistenceMapper::userEntityToUser).toList();
    }
}
