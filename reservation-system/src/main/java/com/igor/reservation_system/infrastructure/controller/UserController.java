package com.igor.reservation_system.infrastructure.controller;

import com.igor.reservation_system.applications.usecases.user.GetAllUsersUseCase;
import com.igor.reservation_system.applications.usecases.user.GetUserByIdUseCase;
import com.igor.reservation_system.applications.usecases.user.SaveUserUseCase;
import com.igor.reservation_system.core.entities.User;
import com.igor.reservation_system.infrastructure.dtos.UserRequest;
import com.igor.reservation_system.infrastructure.dtos.UserResponse;
import com.igor.reservation_system.infrastructure.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private SaveUserUseCase saveUserUseCase;
    private GetAllUsersUseCase getAllUsersUseCase;
    private GetUserByIdUseCase getUserByIdUseCase;
    private UserMapper userMapper;

    public UserController(SaveUserUseCase saveUserUseCase, GetAllUsersUseCase getAllUsersUseCase,
                          GetUserByIdUseCase getUserByIdUseCase, UserMapper userMapper) {

        this.saveUserUseCase = saveUserUseCase;
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.userMapper = userMapper;
    }


    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest userRequest) {


        var user = saveUserUseCase.saveUserUseCase(userMapper.toUserFromUserRequest(userRequest));
        return new ResponseEntity<>(userMapper.toUserResponseFromUser(user), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {

        var allUsers = getAllUsersUseCase.getAllUsersUseCase();

        var response =  allUsers.stream()
                .map(
                        user -> userMapper.toUserResponseFromUser(user)
                ).toList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserResponse> getUserById(
            @PathVariable(name = "user-id") Long userId
    ) {

        User userFound = getUserByIdUseCase.getUserByIdUseCase(userId);
        return new ResponseEntity<>(userMapper.toUserResponseFromUser(userFound), HttpStatus.OK);
    }

}
