package com.igor.reservation_system.applications.usecases.hotel.impl;

import com.igor.reservation_system.applications.exceptions.HotelAlreadyExistsException;
import com.igor.reservation_system.applications.usecases.hotel.SaveHotelUseCase;
import com.igor.reservation_system.core.entities.Hotel;
import com.igor.reservation_system.core.gateways.HotelGateway;

public class SaveHotelUseCaseImpl implements SaveHotelUseCase {

    private HotelGateway hotelGateway;

    public SaveHotelUseCaseImpl(HotelGateway hotelGateway) {
        this.hotelGateway = hotelGateway;
    }


    @Override
    public Hotel saveHotelUseCase(Hotel hotel) {

        if (hotelGateway.existsHotelByName(hotel.name())) {
            throw new HotelAlreadyExistsException("The hotel with name: " + hotel.name() + " is already registered");
        }

        return hotelGateway.saveHotel(hotel);
    }
}
