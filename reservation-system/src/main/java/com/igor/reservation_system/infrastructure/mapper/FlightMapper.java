package com.igor.reservation_system.infrastructure.mapper;

import com.igor.reservation_system.core.entities.Flight;
import com.igor.reservation_system.infrastructure.dtos.FlightDto;
import com.igor.reservation_system.infrastructure.persistence.FlightEntity;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {

    public FlightEntity toFlightEntityFromFlight(Flight flight) {

        FlightEntity flightEntity = new FlightEntity();

        flightEntity.setFlightNumber(flight.flightNumber());
        flightEntity.setOrigin(flight.origin());
        flightEntity.setDestination(flight.destination());
        flightEntity.setDepartureTime(flight.departureTime());
        flightEntity.setArrivalTime(flight.arrivalTime());
        flightEntity.setAvailableSeats(flight.availableSeats());
        flightEntity.setPrice(flight.price());

        return flightEntity;
    }

    public Flight toFlightFromFlightEntity(FlightEntity flightEntity) {

        Flight flight = new Flight(
                null,
                flightEntity.getFlightNumber(),
                flightEntity.getOrigin(),
                flightEntity.getDestination(),
                flightEntity.getDepartureTime(),
                flightEntity.getArrivalTime(),
                flightEntity.getAvailableSeats(),
                flightEntity.getPrice()
        );

        return flight;
    }

    public Flight toFlightFromFlightDto(FlightDto dto) {

       return new Flight(
               null,
               dto.flightNumber(),
               dto.origin(),
               dto.destination(),
               dto.departureTime(),
               dto.arrivalTime(),
               dto.availableSeats(),
               dto.price()
       );
    }

    public FlightDto toFlightDtoFromFlight(Flight flight) {

        return new FlightDto(
                flight.flightNumber(),
                flight.origin(),
                flight.destination(),
                flight.departureTime(),
                flight.arrivalTime(),
                flight.availableSeats(),
                flight.price()
        );
    }

}
