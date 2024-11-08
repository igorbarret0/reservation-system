package com.igor.reservation_system.infrastructure.mapper;

import com.igor.reservation_system.core.entities.Payment;
import com.igor.reservation_system.infrastructure.dtos.PaymentRequest;
import com.igor.reservation_system.infrastructure.dtos.PaymentResponse;
import com.igor.reservation_system.infrastructure.persistence.PaymentEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public Payment toPaymentFromPaymentEntity(PaymentEntity entity) {

        return new Payment(
          null,
           entity.getUserId(),
           entity.getAmount(),
           entity.getPaymentMethod(),
           entity.getPaymentStatus(),
           entity.getPaymentDate(),
           entity.getReservationId(),
           entity.getReservationType()
        );
    }

    public PaymentEntity toPaymentEntityFromPayment(Payment payment) {

        return new PaymentEntity(
          null,
          payment.userId(),
          payment.amount(),
          payment.paymentMethod(),
          payment.paymentStatus(),
          payment.paymentDate(),
          payment.reservationId(),
          payment.reservationType()
        );
    }

    public Payment toPaymentFromPaymentRequest(PaymentRequest request) {

        return new Payment(
                null,
                request.userId(),
                null,
                request.paymentMethod(),
                null,
                null,
                request.reservationId(),
                null
        );
    }

    public PaymentResponse toPaymentResponseFromPayment(Payment payment) {

        return new PaymentResponse(
                payment.amount(),
                payment.paymentMethod(),
                payment.reservationType()
        );
    }

}
