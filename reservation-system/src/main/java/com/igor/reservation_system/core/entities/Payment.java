package com.igor.reservation_system.core.entities;

import com.igor.reservation_system.core.enums.PaymentMethod;
import com.igor.reservation_system.core.enums.PaymentStatus;
import com.igor.reservation_system.core.enums.ReservationType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Payment(
        Long id,
        Long userId,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        PaymentStatus paymentStatus,
        LocalDateTime paymentDate,
        Long reservationId,
        ReservationType reservationType
) {
}
