package com.igor.reservation_system.infrastructure.controller;

import com.igor.reservation_system.applications.usecases.hotelReservation.MakeHotelReservationUseCase;
import com.igor.reservation_system.infrastructure.dtos.HotelReservationRequest;
import com.igor.reservation_system.infrastructure.mapper.HotelReservationMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hotel/reservation")
public class HotelReservationController {

    private MakeHotelReservationUseCase makeHotelReservationUseCase;
    private HotelReservationMapper mapper;

    public HotelReservationController(MakeHotelReservationUseCase makeHotelReservationUseCase, HotelReservationMapper mapper) {
        this.makeHotelReservationUseCase = makeHotelReservationUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<String> makeHotelReservation(
            @RequestBody HotelReservationRequest request
    ) {

        makeHotelReservationUseCase.makeHotelReservationUseCase(mapper.toHotelReservationFromHotelReservationRequest(request));
        return new ResponseEntity<>("Your reservation has been successfully created and is pending payment for confirmation.", HttpStatus.OK);
    }

}
