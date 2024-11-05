package com.igor.reservation_system.core.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Flight(
        Long id,
        String flightNumber,
        String origin,
        String destination,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime,
        int availableSeats,
        BigDecimal price
) {
}
