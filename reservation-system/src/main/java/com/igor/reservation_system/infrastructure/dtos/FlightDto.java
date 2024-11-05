package com.igor.reservation_system.infrastructure.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FlightDto(
        String flightNumber,
        String origin,
        String destination,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime,
        int availableSeats,
        BigDecimal price
) {
}
