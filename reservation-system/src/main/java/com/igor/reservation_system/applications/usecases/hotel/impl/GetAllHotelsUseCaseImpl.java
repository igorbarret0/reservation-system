package com.igor.reservation_system.applications.usecases.hotel.impl;

import com.igor.reservation_system.applications.usecases.hotel.GetAllHotelsUseCase;
import com.igor.reservation_system.core.entities.Hotel;
import com.igor.reservation_system.core.gateways.HotelGateway;

import java.util.List;

public class GetAllHotelsUseCaseImpl implements GetAllHotelsUseCase {

    private HotelGateway hotelGateway;

    public GetAllHotelsUseCaseImpl(HotelGateway hotelGateway) {
        this.hotelGateway = hotelGateway;
    }

    @Override
    public List<Hotel> getAllHotelsUseCase() {

        return hotelGateway.getAllHotels();
    }
}
