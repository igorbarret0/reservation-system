package com.igor.reservation_system.infrastructure.dtos;

import java.time.LocalDateTime;

public record FlightReservationRequest(
        Long flightId,
        Long userId,
        LocalDateTime reservationDate,
        Integer seatsReserved
) {
}
