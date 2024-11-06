package com.igor.reservation_system.infrastructure.dtos;

public record UserResponse(
        String name,
        String email,
        String phoneNumber
) {
}
