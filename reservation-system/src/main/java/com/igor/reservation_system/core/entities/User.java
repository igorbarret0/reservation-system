package com.igor.reservation_system.core.entities;

public record User(
        Long id,
        String name,
        String email,
        String phoneNumber,
        String address
) {
}
