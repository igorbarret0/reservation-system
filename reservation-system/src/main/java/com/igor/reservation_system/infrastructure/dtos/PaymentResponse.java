package com.igor.reservation_system.infrastructure.dtos;

import com.igor.reservation_system.core.enums.PaymentMethod;
import com.igor.reservation_system.core.enums.ReservationType;

import java.math.BigDecimal;

public record PaymentResponse(

        BigDecimal amount,
        PaymentMethod paymentMethod,
        ReservationType reservationType
) {
}
