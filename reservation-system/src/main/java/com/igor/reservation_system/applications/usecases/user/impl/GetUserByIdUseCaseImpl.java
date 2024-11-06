package com.igor.reservation_system.applications.usecases.user.impl;

import com.igor.reservation_system.applications.exceptions.UserNotFoundException;
import com.igor.reservation_system.applications.usecases.user.GetUserByIdUseCase;
import com.igor.reservation_system.core.entities.User;
import com.igor.reservation_system.core.gateways.UserGateway;

public class GetUserByIdUseCaseImpl implements GetUserByIdUseCase {

    private UserGateway userGateway;

    public GetUserByIdUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User getUserByIdUseCase(Long id) {

        User userFound = userGateway.getUserById(id);

        if (userFound == null) {
            throw new UserNotFoundException("User could not be found with the provided ID: " + id);
        }

        return userFound;
    }
}
