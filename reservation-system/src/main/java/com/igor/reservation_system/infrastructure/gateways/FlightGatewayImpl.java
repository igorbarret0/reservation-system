package com.igor.reservation_system.infrastructure.gateways;

import com.igor.reservation_system.core.entities.Flight;
import com.igor.reservation_system.core.gateways.FlightGateway;
import com.igor.reservation_system.infrastructure.mapper.FlightMapper;
import com.igor.reservation_system.infrastructure.persistence.FlightEntity;
import com.igor.reservation_system.infrastructure.persistence.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightGatewayImpl implements FlightGateway {

    private FlightRepository flightRepository;
    private FlightMapper flightMapper;

    public FlightGatewayImpl(FlightRepository flightRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }

    @Override
    public Flight saveFlight(Flight flight) {

        var flightEntity = flightRepository.save(flightMapper.toFlightEntityFromFlight(flight));
        return flightMapper.toFlightFromFlightEntity(flightEntity);
    }

    @Override
    public List<Flight> getAllFlights() {

        return flightRepository.findAll()
                .stream().map(
                        flightEntity -> flightMapper.toFlightFromFlightEntity(flightEntity)
                ).toList();
    }

    @Override
    public Flight getFlightById(Long id) {

        FlightEntity flightEntity = flightRepository.findFlightById(id);
        return flightMapper.toFlightFromFlightEntity(flightEntity);
    }

    @Override
    public List<Flight> getFlightsByDestination(String destination) {

        return flightRepository.findAllFlightsByDestination(destination)
                .stream().map(flightEntity -> flightMapper.toFlightFromFlightEntity(flightEntity)
                ).toList();
    }

}
