package com.igor.reservation_system.infrastructure.dtos;

import java.math.BigDecimal;

public record HotelRequest(
        String name,
        String location,
        Integer totalRooms,
        BigDecimal pricePerNight,
        String amenities
) {
}
