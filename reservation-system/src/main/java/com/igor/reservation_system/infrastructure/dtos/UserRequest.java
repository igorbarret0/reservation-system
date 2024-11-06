package com.igor.reservation_system.infrastructure.dtos;

public record UserRequest(
        String name,
        String email,
        String phoneNumber,
        String address
) {
}
