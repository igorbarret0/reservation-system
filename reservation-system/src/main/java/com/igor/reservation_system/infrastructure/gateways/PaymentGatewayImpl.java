package com.igor.reservation_system.infrastructure.gateways;

import com.igor.reservation_system.core.entities.Payment;
import com.igor.reservation_system.core.gateways.PaymentGateway;
import com.igor.reservation_system.infrastructure.mapper.PaymentMapper;
import com.igor.reservation_system.infrastructure.persistence.repositories.PaymentRepository;
import com.igor.reservation_system.infrastructure.service.PaymentProducer;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayImpl implements PaymentGateway {

    private PaymentRepository paymentRepository;
    private PaymentMapper paymentMapper;
    private PaymentProducer paymentProducer;

    public PaymentGatewayImpl(PaymentRepository paymentRepository, PaymentMapper paymentMapper,
                              PaymentProducer paymentProducer) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
        this.paymentProducer = paymentProducer;
    }

    @Override
    public Payment makePayment(Payment payment) {

        var paymentEntity = paymentRepository.save(paymentMapper.toPaymentEntityFromPayment(payment));
        paymentProducer.processPayment(
                new Payment(
                        paymentEntity.getId(),
                        paymentEntity.getUserId(),
                        paymentEntity.getAmount(),
                        paymentEntity.getPaymentMethod(),
                        paymentEntity.getPaymentStatus(),
                        null,
                        paymentEntity.getReservationId(),
                        paymentEntity.getReservationType()

                )
        );
        return paymentMapper.toPaymentFromPaymentEntity(paymentEntity);
    }
}
