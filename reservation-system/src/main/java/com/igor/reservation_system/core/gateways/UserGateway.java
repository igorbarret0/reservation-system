package com.igor.reservation_system.core.gateways;

import com.igor.reservation_system.core.entities.User;

import java.util.List;

public interface UserGateway {

    User saveUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    boolean emailExist(String email);

    boolean phoneNumberExist(String phoneNumber);
}
