package com.igor.reservation_system.infrastructure.controller;

import com.igor.reservation_system.applications.usecases.GetAllFlightsUseCase;
import com.igor.reservation_system.applications.usecases.GetFlightByIdUseCase;
import com.igor.reservation_system.applications.usecases.GetFlightsByDestinationUseCase;
import com.igor.reservation_system.applications.usecases.SaveFlightUseCase;
import com.igor.reservation_system.core.entities.Flight;
import com.igor.reservation_system.infrastructure.dtos.FlightDto;
import com.igor.reservation_system.infrastructure.mapper.FlightMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {


    private GetAllFlightsUseCase getAllFlightsUseCase;
    private GetFlightByIdUseCase getFlightByIdUseCase;
    private SaveFlightUseCase saveFlightUseCase;
    private GetFlightsByDestinationUseCase getFlightsByDestinationUseCase;
    private FlightMapper flightMapper;

    public FlightController (GetAllFlightsUseCase getAllFlightsUseCase, GetFlightByIdUseCase getFlightByIdUseCase,
                             SaveFlightUseCase saveFlightUseCase, FlightMapper flightMapper, GetFlightsByDestinationUseCase getFlightsByDestinationUseCase) {
        this.getAllFlightsUseCase = getAllFlightsUseCase;
        this.getFlightByIdUseCase = getFlightByIdUseCase;
        this.saveFlightUseCase = saveFlightUseCase;
        this.getFlightsByDestinationUseCase = getFlightsByDestinationUseCase;
        this.flightMapper = flightMapper;
    }

    @PostMapping
    public ResponseEntity<FlightDto> saveFlight(@RequestBody FlightDto flightDto) {

        var response = saveFlightUseCase.saveFlightUseCase(flightMapper.toFlightFromFlightDto(flightDto));
        return new ResponseEntity<>(flightMapper.toFlightDtoFromFlight(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FlightDto>> getAllFlights() {

        var response = getAllFlightsUseCase.getAllFlightsUseCase().stream().map(
                flight -> flightMapper.toFlightDtoFromFlight(flight)
        ).toList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{flight-id}")
    public ResponseEntity<FlightDto> getFlightById(
            @PathVariable(name = "flight-id") Long flightId
    ) {

        var response = getFlightByIdUseCase.getFlightByIdUseCase(flightId);
        return new ResponseEntity<>(flightMapper.toFlightDtoFromFlight(response), HttpStatus.OK);
    }

    @GetMapping("/destination/{destination}")
    public ResponseEntity<List<FlightDto>> getFlightsByDestination(
            @PathVariable(name = "destination") String destination
    ) {


        List<Flight> flights = getFlightsByDestinationUseCase.getFlightsByDestination(destination);
        List<FlightDto> response = flights.stream().map(
                flight -> flightMapper.toFlightDtoFromFlight(flight)
        ).toList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
