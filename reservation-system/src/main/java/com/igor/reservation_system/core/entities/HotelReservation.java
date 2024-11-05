package com.igor.reservation_system.core.entities;

import com.igor.reservation_system.core.enums.ReservationStatus;

import java.time.LocalDate;

public record HotelReservation(
        Long id,
        Long hotelId,
        Long userId,
        LocalDate checkInDate,
        LocalDate checkOutDate,
        int roomsReserved,
        ReservationStatus reservationStatus
) {
}
