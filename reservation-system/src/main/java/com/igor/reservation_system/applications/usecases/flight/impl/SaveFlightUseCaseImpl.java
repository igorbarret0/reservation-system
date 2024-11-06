package com.igor.reservation_system.applications.usecases.flight.impl;

import com.igor.reservation_system.applications.usecases.flight.SaveFlightUseCase;
import com.igor.reservation_system.core.entities.Flight;
import com.igor.reservation_system.core.gateways.FlightGateway;

import java.time.LocalDateTime;

public class SaveFlightUseCaseImpl implements SaveFlightUseCase {

    private FlightGateway flightGateway;

    public SaveFlightUseCaseImpl(FlightGateway flightGateway) {
        this.flightGateway = flightGateway;
    }

    @Override
    public Flight saveFlightUseCase(Flight flight) {

        LocalDateTime now = LocalDateTime.now();

        if (flight.departureTime().isBefore(now)) {
            throw new IllegalArgumentException("Departure time must be in the future.");
        }

        if (flight.arrivalTime().isBefore(now)) {
            throw new IllegalArgumentException("Arrival time must be in the future.");
        }

        if (flight.arrivalTime().isBefore(flight.departureTime())) {
            throw new IllegalArgumentException("Arrival time must be after departure time.");
        }

        return flightGateway.saveFlight(flight);
    }
}
