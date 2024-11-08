package com.igor.reservation_system.applications.usecases.payment.impl;

import com.igor.reservation_system.applications.exceptions.ReservationNotFoundException;
import com.igor.reservation_system.applications.exceptions.UserNotFoundException;
import com.igor.reservation_system.applications.usecases.payment.MakePaymentUseCase;
import com.igor.reservation_system.core.entities.Payment;
import com.igor.reservation_system.core.enums.PaymentStatus;
import com.igor.reservation_system.core.enums.ReservationType;
import com.igor.reservation_system.core.gateways.FlightGateway;
import com.igor.reservation_system.core.gateways.FlightReservationGateway;
import com.igor.reservation_system.core.gateways.PaymentGateway;
import com.igor.reservation_system.core.gateways.UserGateway;

import java.math.BigDecimal;

public class MakePaymentUseCaseImpl implements MakePaymentUseCase {

    private FlightReservationGateway flightReservationGateway;
    private FlightGateway flightGateway;
    private UserGateway userGateway;
    private PaymentGateway paymentGateway;

    public MakePaymentUseCaseImpl(FlightReservationGateway flightReservationGateway, FlightGateway flightGateway, UserGateway userGateway, PaymentGateway paymentGateway) {
        this.flightReservationGateway = flightReservationGateway;
        this.flightGateway = flightGateway;
        this.userGateway = userGateway;
        this.paymentGateway = paymentGateway;
    }

    @Override
    public Payment makePaymentUseCase(Payment payment) {

        var reservation = flightReservationGateway.getFlightById(payment.reservationId());
        if (reservation == null) {
            throw new ReservationNotFoundException("There is no reservation with the provided ID: " + payment.reservationId());
        }

        var flight = flightGateway.getFlightById(reservation.flightId());

        var user = userGateway.getUserById(payment.userId());
        if (user == null) {
            throw new UserNotFoundException("User could not be found with the provided ID: " + payment.userId());
        }

        var totalToPay = flight.price().multiply(BigDecimal.valueOf(reservation.seatsReserved()));

        var newPayment = new Payment(
              null,
              payment.userId(),
              totalToPay,
              payment.paymentMethod(),
              PaymentStatus.PENDING,
                null,
                payment.reservationId(),
                ReservationType.FLIGHT
        );

        return paymentGateway.makePayment(newPayment);
    }

}
