package com.igor.reservation_system.applications.usecases.flightReservation.impl;

import com.igor.reservation_system.applications.exceptions.FlightDoesNotExistException;
import com.igor.reservation_system.applications.exceptions.InsufficientSeatsAvailableException;
import com.igor.reservation_system.applications.exceptions.InvalidScheduleReservationException;
import com.igor.reservation_system.applications.exceptions.UserNotFoundException;
import com.igor.reservation_system.applications.usecases.flightReservation.MakeFlightReservationUseCase;
import com.igor.reservation_system.core.entities.FlightReservation;
import com.igor.reservation_system.core.gateways.FlightGateway;
import com.igor.reservation_system.core.gateways.FlightReservationGateway;
import com.igor.reservation_system.core.gateways.UserGateway;

import java.time.LocalDateTime;


public class MakeFlightReservationUseCaseImpl implements MakeFlightReservationUseCase {

    private FlightReservationGateway flightReservationGateway;
    private UserGateway userGateway;
    private FlightGateway flightGateway;

    public MakeFlightReservationUseCaseImpl(FlightReservationGateway flightReservationGateway, UserGateway userGateway,
                                            FlightGateway flightGateway) {
        this.flightReservationGateway = flightReservationGateway;
        this.userGateway = userGateway;
        this.flightGateway = flightGateway;
    }

    @Override
    public void makeFlightReservationUseCase(FlightReservation flightReservation) {

        if (userGateway.getUserById(flightReservation.userId()) == null) {
            throw new UserNotFoundException("Could not found user with the provided ID: " + flightReservation.userId());
        }

        var flightFound = flightGateway.getFlightById(flightReservation.flightId());
        if (flightFound == null) {
            throw new FlightDoesNotExistException("Flight does not exists");
        }

        LocalDateTime now = LocalDateTime.now();
        if (flightReservation.reservationDate().isBefore(now)) {
            throw new InvalidScheduleReservationException("The reservation date must be in the future");
        }

        if (flightFound.departureTime().getDayOfMonth() != flightReservation.reservationDate().getDayOfMonth()) {
            throw new InvalidScheduleReservationException("The selected reservation date does not match the scheduled departure date for this flight.");
        }

        if ((flightFound.availableSeats() - flightReservation.seatsReserved()) < 0) {
            throw new InsufficientSeatsAvailableException("Not enough seats available for the requested reservation.");
        }

        flightGateway.updateAvailableSeats(flightReservation.flightId(), flightReservation.seatsReserved());

        flightReservationGateway.makeFlightReservation(flightReservation);
    }
}
