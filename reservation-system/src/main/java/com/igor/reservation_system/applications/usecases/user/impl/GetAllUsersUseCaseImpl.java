package com.igor.reservation_system.applications.usecases.user.impl;

import com.igor.reservation_system.applications.usecases.user.GetAllUsersUseCase;
import com.igor.reservation_system.core.entities.User;
import com.igor.reservation_system.core.gateways.UserGateway;

import java.util.List;

public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase {

    private UserGateway userGateway;

    public GetAllUsersUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public List<User> getAllUsersUseCase() {

        return userGateway.getAllUsers();
    }

}
