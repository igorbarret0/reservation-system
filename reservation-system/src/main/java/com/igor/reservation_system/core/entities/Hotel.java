package com.igor.reservation_system.core.entities;

import java.math.BigDecimal;

public record Hotel(
        Long id,
        String name,
        String location,
        int totalRooms,
        BigDecimal pricePerNight,
        String amenities
) {
}
