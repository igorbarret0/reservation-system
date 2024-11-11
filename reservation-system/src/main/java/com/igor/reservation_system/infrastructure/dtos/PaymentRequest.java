package com.igor.reservation_system.infrastructure.dtos;

import com.igor.reservation_system.core.enums.PaymentMethod;
import com.igor.reservation_system.core.enums.ReservationType;

public record PaymentRequest(
        Long userId,
        Long reservationId,
        PaymentMethod paymentMethod,
        ReservationType reservationType
) {
}
