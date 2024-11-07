package com.igor.reservation_system.core.gateways;

import com.igor.reservation_system.core.entities.Flight;

import java.util.List;

public interface FlightGateway {

    Flight saveFlight(Flight flight);

    List<Flight> getAllFlights();

    Flight getFlightById(Long id);

    List<Flight> getFlightsByDestination(String destination);

    void updateAvailableSeats(Long flightId, int seatsReserved);

}
