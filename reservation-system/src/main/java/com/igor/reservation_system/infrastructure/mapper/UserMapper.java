package com.igor.reservation_system.infrastructure.mapper;

import com.igor.reservation_system.core.entities.User;
import com.igor.reservation_system.infrastructure.dtos.UserRequest;
import com.igor.reservation_system.infrastructure.dtos.UserResponse;
import com.igor.reservation_system.infrastructure.persistence.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUserFromUserEntity(UserEntity entity) {

        var user = new User(
          null,
                entity.getName(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getAddress()
        );

        return user;
    }

    public UserEntity toUserEntityFromUser(User user) {

        var userEntity = new UserEntity();
        userEntity.setName(user.name());
        userEntity.setEmail(user.email());
        userEntity.setPhoneNumber(user.phoneNumber());
        userEntity.setAddress(user.address());

        return userEntity;
    }

    public User toUserFromUserRequest(UserRequest userRequest) {

        return new User(
                null,
                userRequest.name(),
                userRequest.email(),
                userRequest.phoneNumber(),
                userRequest.address()
        );
    }

    public UserResponse toUserResponseFromUser(User user) {

        return new UserResponse(
                user.name(),
                user.email(),
                user.phoneNumber()
        );
    }

}
