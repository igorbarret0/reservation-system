package com.igor.reservation_system.applications.usecases.impl;

import com.igor.reservation_system.applications.usecases.GetFlightsByDestinationUseCase;
import com.igor.reservation_system.core.entities.Flight;
import com.igor.reservation_system.core.gateways.FlightGateway;

import java.time.LocalDateTime;
import java.util.List;

public class GetFlightsByDestinationUseCaseImpl implements GetFlightsByDestinationUseCase {

    private FlightGateway flightGateway;

    public GetFlightsByDestinationUseCaseImpl(FlightGateway flightGateway) {
        this.flightGateway = flightGateway;
    }

    @Override
    public List<Flight> getFlightsByDestination(String destination) {

        var allFlights = flightGateway.getFlightsByDestination(destination);

        LocalDateTime now = LocalDateTime.now();

        // Filter flights who are still available
        List<Flight> availableFlights = allFlights.stream()
                .filter(flight -> flight.departureTime().isAfter(now))
                .toList();

        return availableFlights;
    }

}
