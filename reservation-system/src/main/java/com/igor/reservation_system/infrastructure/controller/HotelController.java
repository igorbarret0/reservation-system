package com.igor.reservation_system.infrastructure.controller;

import com.igor.reservation_system.applications.usecases.hotel.GetAllHotelsUseCase;
import com.igor.reservation_system.applications.usecases.hotel.GetHotelByIdUseCase;
import com.igor.reservation_system.applications.usecases.hotel.GetHotelsByLocationUseCase;
import com.igor.reservation_system.applications.usecases.hotel.SaveHotelUseCase;
import com.igor.reservation_system.infrastructure.dtos.HotelRequest;
import com.igor.reservation_system.infrastructure.dtos.HotelResponse;
import com.igor.reservation_system.infrastructure.mapper.HotelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    private SaveHotelUseCase saveHotelUseCase;
    private GetAllHotelsUseCase getAllHotelsUseCase;
    private GetHotelByIdUseCase getHotelByIdUseCase;
    private GetHotelsByLocationUseCase getHotelsByLocationUseCase;
    private HotelMapper mapper;

    public HotelController(SaveHotelUseCase saveHotelUseCase, GetAllHotelsUseCase getAllHotelsUseCase,
                           GetHotelByIdUseCase getHotelByIdUseCase, GetHotelsByLocationUseCase getHotelsByLocationUseCase, HotelMapper mapper) {
        this.saveHotelUseCase = saveHotelUseCase;
        this.getAllHotelsUseCase = getAllHotelsUseCase;
        this.getHotelByIdUseCase = getHotelByIdUseCase;
        this.getHotelsByLocationUseCase = getHotelsByLocationUseCase;
        this.mapper = mapper;
    }


    @PostMapping
    public ResponseEntity<HotelResponse> saveHotel(
            @RequestBody HotelRequest request
    ) {

        var hotelSaved = saveHotelUseCase.saveHotelUseCase(mapper.toHotelFromHotelRequest(request));
        return new ResponseEntity<>(mapper.toHotelResponseFromHotel(hotelSaved), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<HotelResponse>> getAllHotels() {

        var response = getAllHotelsUseCase.getAllHotelsUseCase()
                .stream().map(
                        hotel -> mapper.toHotelResponseFromHotel(hotel)
                ).toList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/id/{hotel-id}")
    public ResponseEntity<HotelResponse> getHotelById(
            @PathVariable(name = "hotel-id") Long hotelId
    ) {

        var hotelFound = getHotelByIdUseCase.getHotelByIdUseCase(hotelId);
        return new ResponseEntity<>(mapper.toHotelResponseFromHotel(hotelFound), HttpStatus.OK);
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<HotelResponse>> getAllHotelsByLocation(
            @PathVariable(name = "location") String location
    ) {

        var response = getHotelsByLocationUseCase.getHotelsByLocationUseCase(location)
                .stream().map(
                        hotel -> mapper.toHotelResponseFromHotel(hotel)
                ).toList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
