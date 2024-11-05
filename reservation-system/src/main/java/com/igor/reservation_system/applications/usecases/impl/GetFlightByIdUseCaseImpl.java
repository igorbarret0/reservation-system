package com.igor.reservation_system.applications.usecases.impl;

import com.igor.reservation_system.applications.exceptions.FlightDoesNotExistException;
import com.igor.reservation_system.applications.usecases.GetFlightByIdUseCase;
import com.igor.reservation_system.core.entities.Flight;
import com.igor.reservation_system.core.gateways.FlightGateway;

public class GetFlightByIdUseCaseImpl implements GetFlightByIdUseCase {

    public FlightGateway flightGateway;

    public GetFlightByIdUseCaseImpl(FlightGateway flightGateway) {
        this.flightGateway = flightGateway;
    }

    @Override
    public Flight getFlightByIdUseCase(Long id) {

        flightDoesExists(id);
        return flightGateway.getFlightById(id);
    }

    private void flightDoesExists(Long id) {

        if (flightGateway.getFlightById(id) == null) {
            throw new FlightDoesNotExistException("A flight could not be found with the provided ID: " + id);
        }
    }

}
