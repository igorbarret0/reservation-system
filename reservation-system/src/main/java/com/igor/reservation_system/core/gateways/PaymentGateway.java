package com.igor.reservation_system.core.gateways;

import com.igor.reservation_system.core.entities.Payment;

public interface PaymentGateway {

    Payment makePayment(Payment payment);

}
