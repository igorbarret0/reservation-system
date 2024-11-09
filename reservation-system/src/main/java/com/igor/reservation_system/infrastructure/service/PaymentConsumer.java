package com.igor.reservation_system.infrastructure.service;

import com.igor.reservation_system.core.entities.Payment;
import com.igor.reservation_system.core.enums.PaymentStatus;
import com.igor.reservation_system.core.enums.ReservationStatus;
import com.igor.reservation_system.core.enums.ReservationType;
import com.igor.reservation_system.infrastructure.configurations.RabbitMQConfig;
import com.igor.reservation_system.infrastructure.persistence.repositories.FlightReservationRepository;
import com.igor.reservation_system.infrastructure.persistence.repositories.PaymentRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentConsumer {

    private PaymentRepository paymentRepository;
    private FlightReservationRepository flightReservationRepository;

    public PaymentConsumer(PaymentRepository paymentRepository, FlightReservationRepository flightReservationRepository) {
        this.paymentRepository = paymentRepository;
        this.flightReservationRepository = flightReservationRepository;
    }

    @RabbitListener(queues = RabbitMQConfig.PAYMENT_QUEUE)
    public void handlePayment(Payment payment) {

        if (payment.reservationType().equals(ReservationType.FLIGHT)) {
            updateFlightReservationStatus(payment.id(), payment.reservationId(),  payment.paymentStatus());
        }
    }

    private void updateFlightReservationStatus(Long paymentId, Long flightReservationId, PaymentStatus paymentStatus) {

        var payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment could not be found"));

        var reservation = flightReservationRepository.findById(flightReservationId)
                        .orElseThrow(() -> new RuntimeException("Reservation could not be found"));

        payment.setPaymentStatus(PaymentStatus.COMPLETED);
        payment.setPaymentDate(LocalDateTime.now());
        paymentRepository.save(payment);

        reservation.setReservationStatus(ReservationStatus.CONFIRMED);
        flightReservationRepository.save(reservation);
    }

    private void updateHotelReservationStatus(Long paymentId, PaymentStatus paymentStatus) {

        //TODO
    }
}
