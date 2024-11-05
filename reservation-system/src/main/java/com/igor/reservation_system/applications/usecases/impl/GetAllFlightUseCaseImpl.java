package com.igor.reservation_system.applications.usecases.impl;

import com.igor.reservation_system.applications.usecases.GetAllFlightsUseCase;
import com.igor.reservation_system.core.entities.Flight;
import com.igor.reservation_system.core.gateways.FlightGateway;

import java.util.List;

public class GetAllFlightUseCaseImpl implements GetAllFlightsUseCase {

    private FlightGateway flightGateway;

    public GetAllFlightUseCaseImpl(FlightGateway flightGateway) {
        this.flightGateway = flightGateway;
    }

    @Override
    public List<Flight> getAllFlightsUseCase() {

        return flightGateway.getAllFlights();
    }
}
