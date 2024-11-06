package com.igor.reservation_system.applications.usecases.flight;

import com.igor.reservation_system.core.entities.Flight;

import java.util.List;

public interface GetFlightsByDestinationUseCase {

    List<Flight> getFlightsByDestination(String destination);

}
