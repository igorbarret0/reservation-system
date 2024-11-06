package com.igor.reservation_system.infrastructure.gateways;

import com.igor.reservation_system.core.entities.User;
import com.igor.reservation_system.core.gateways.UserGateway;
import com.igor.reservation_system.infrastructure.mapper.UserMapper;
import com.igor.reservation_system.infrastructure.persistence.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGatewayImpl implements UserGateway {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserGatewayImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User saveUser(User user) {

        var userEntity = userRepository.save(userMapper.toUserEntityFromUser(user));
        return userMapper.toUserFromUserEntity(userEntity);
    }

    @Override
    public User getUserById(Long id) {

        var userFound = userRepository.findUserById(id);
        return userMapper.toUserFromUserEntity(userFound);
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll()
                .stream().map(
                        userEntity -> userMapper.toUserFromUserEntity(userEntity)
                ).toList();
    }

    @Override
    public boolean emailExist(String email) {

        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean phoneNumberExist(String phoneNumber) {

        return userRepository.existsByPhoneNumber(phoneNumber);
    }

}
