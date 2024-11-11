package com.igor.reservation_system.infrastructure.dtos;

import java.time.LocalDate;

public record HotelReservationRequest(
        Long hotelId,
        Long userId,
        LocalDate checkInDate,
        LocalDate checkOutDate,
        int roomsReserved
) {
}
