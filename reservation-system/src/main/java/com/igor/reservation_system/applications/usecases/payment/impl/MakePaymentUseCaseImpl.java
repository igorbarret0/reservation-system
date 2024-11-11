package com.igor.reservation_system.applications.usecases.payment.impl;

import com.igor.reservation_system.applications.exceptions.HotelNotFoundException;
import com.igor.reservation_system.applications.exceptions.ReservationNotFoundException;
import com.igor.reservation_system.applications.exceptions.UserNotFoundException;
import com.igor.reservation_system.applications.usecases.payment.MakePaymentUseCase;
import com.igor.reservation_system.core.entities.Payment;
import com.igor.reservation_system.core.entities.User;
import com.igor.reservation_system.core.enums.PaymentStatus;
import com.igor.reservation_system.core.enums.ReservationType;
import com.igor.reservation_system.core.gateways.*;

import java.math.BigDecimal;

public class MakePaymentUseCaseImpl implements MakePaymentUseCase {

    private FlightReservationGateway flightReservationGateway;
    private HotelReservationGateway hotelReservationGateway;
    private HotelGateway hotelGateway;
    private FlightGateway flightGateway;
    private UserGateway userGateway;
    private PaymentGateway paymentGateway;

    public MakePaymentUseCaseImpl(FlightReservationGateway flightReservationGateway, FlightGateway flightGateway, UserGateway userGateway,
                                  PaymentGateway paymentGateway, HotelReservationGateway hotelReservationGateway, HotelGateway hotelGateway) {
        this.flightReservationGateway = flightReservationGateway;
        this.flightGateway = flightGateway;
        this.userGateway = userGateway;
        this.paymentGateway = paymentGateway;
        this.hotelReservationGateway = hotelReservationGateway;
        this.hotelGateway = hotelGateway;
    }


    @Override
    public Payment makePaymentUseCase(Payment payment) {

        var user = validateUser(payment.userId());

        BigDecimal totalToPay;
        if (payment.reservationType() == ReservationType.FLIGHT) {
            totalToPay = calculateFlightPayment(payment);
        } else if (payment.reservationType() == ReservationType.HOTEL) {
            totalToPay = calculateHotelPayment(payment);
        } else {
            throw new UnsupportedOperationException("Reservation type not supported: " + payment.reservationType());
        }

        var newPayment = new Payment(
                null,
                payment.userId(),
                totalToPay,
                payment.paymentMethod(),
                PaymentStatus.PENDING,
                null,
                payment.reservationId(),
                payment.reservationType()
        );

        return paymentGateway.makePayment(newPayment);
    }

    private User validateUser(Long userId) {
        var user = userGateway.getUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("User could not be found with the provided ID: " + userId);
        }
        return user;
    }

    private BigDecimal calculateFlightPayment(Payment payment) {
        var reservation = flightReservationGateway.getFlightById(payment.reservationId());
        if (reservation == null) {
            throw new ReservationNotFoundException("There is no flight reservation with the provided ID: " + payment.reservationId());
        }

        var flight = flightGateway.getFlightById(reservation.flightId());
        return flight.price().multiply(BigDecimal.valueOf(reservation.seatsReserved()));
    }

    private BigDecimal calculateHotelPayment(Payment payment) {
        var reservation = hotelReservationGateway.getHotelReservationById(payment.reservationId());
        if (reservation == null) {
            throw new ReservationNotFoundException("There is no hotel reservation with the provided ID: " + payment.reservationId());
        }

        var hotel = hotelGateway.getHotelById(reservation.hotelId());
        if (hotel == null) {
            throw new HotelNotFoundException("Hotel could not be found with the provided ID: " + reservation.hotelId());
        }

        return hotel.pricePerNight().multiply(BigDecimal.valueOf(reservation.roomsReserved()));
    }

}
