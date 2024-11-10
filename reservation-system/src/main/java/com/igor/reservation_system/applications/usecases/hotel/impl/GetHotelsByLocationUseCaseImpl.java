package com.igor.reservation_system.applications.usecases.hotel.impl;

import com.igor.reservation_system.applications.usecases.hotel.GetHotelsByLocationUseCase;
import com.igor.reservation_system.core.entities.Hotel;
import com.igor.reservation_system.core.gateways.HotelGateway;

import java.util.List;

public class GetHotelsByLocationUseCaseImpl implements GetHotelsByLocationUseCase {

    private HotelGateway hotelGateway;

    public GetHotelsByLocationUseCaseImpl(HotelGateway hotelGateway) {
        this.hotelGateway = hotelGateway;
    }

    @Override
    public List<Hotel> getHotelsByLocationUseCase(String location) {

        return hotelGateway.getHotelsByLocation(location);
    }
}
