package com.igor.reservation_system.core.entities;

import com.igor.reservation_system.core.enums.ReservationStatus;

import java.time.LocalDateTime;

public record FlightReservation(
        Long id,
        Long flightId,
        Long userId,
        LocalDateTime reservationDate,
        int seatsReserved,
        ReservationStatus reservationStatus
) {
}
