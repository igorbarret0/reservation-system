package com.igor.reservation_system.applications.usecases.hotel.impl;

import com.igor.reservation_system.applications.exceptions.HotelNotFoundException;
import com.igor.reservation_system.applications.usecases.hotel.GetHotelByIdUseCase;
import com.igor.reservation_system.core.entities.Hotel;
import com.igor.reservation_system.core.gateways.HotelGateway;

public class GetHotelByIdUseCaseImpl implements GetHotelByIdUseCase {

    private HotelGateway hotelGateway;

    public GetHotelByIdUseCaseImpl(HotelGateway hotelGateway) {
        this.hotelGateway = hotelGateway;
    }

    @Override
    public Hotel getHotelByIdUseCase(Long id) {

        var hotelFound = hotelGateway.getHotelById(id);

        if (hotelFound == null) {
            throw new HotelNotFoundException("Could not found hotel with the provided ID: " + id);
        }

        return hotelFound;
    }
}
