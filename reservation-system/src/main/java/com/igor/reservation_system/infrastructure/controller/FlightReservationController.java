package com.igor.reservation_system.infrastructure.controller;

import com.igor.reservation_system.applications.usecases.flightReservation.MakeFlightReservationUseCase;
import com.igor.reservation_system.infrastructure.dtos.FlightReservationRequest;
import com.igor.reservation_system.infrastructure.mapper.FlightReservationMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/flight/reservation")
public class FlightReservationController {

    private MakeFlightReservationUseCase makeFlightReservationUseCase;
    private FlightReservationMapper mapper;

    public FlightReservationController(MakeFlightReservationUseCase makeFlightReservationUseCase, FlightReservationMapper mapper) {
        this.makeFlightReservationUseCase = makeFlightReservationUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<String> makeFlightReservation(
            @RequestBody FlightReservationRequest request
    ) {

        makeFlightReservationUseCase.makeFlightReservationUseCase(mapper.toFlightReservationFromFlightReservationRequest(request));
        return ResponseEntity.ok("Your reservation has been successfully created and is pending payment for confirmation.");
    }

}
