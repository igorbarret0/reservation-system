package com.igor.reservation_system.applications.usecases.user.impl;

import com.igor.reservation_system.applications.exceptions.EmailAlreadyExistException;
import com.igor.reservation_system.applications.exceptions.PhoneNumberAlreadyExistException;
import com.igor.reservation_system.applications.usecases.user.SaveUserUseCase;
import com.igor.reservation_system.core.entities.User;
import com.igor.reservation_system.core.gateways.UserGateway;

public class SaveUserUseCaseImpl implements SaveUserUseCase {

    private UserGateway userGateway;

    public SaveUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User saveUserUseCase(User user) {

        if (userGateway.emailExist(user.email())) {
              throw new EmailAlreadyExistException("A user with this email is already registered");
        }

        if (userGateway.phoneNumberExist(user.phoneNumber())) {
            throw new PhoneNumberAlreadyExistException("A user with this phone number is already registered");
        }

        return userGateway.saveUser(user);
    }
}
