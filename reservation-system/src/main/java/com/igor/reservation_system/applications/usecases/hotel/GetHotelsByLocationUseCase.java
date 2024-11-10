package com.igor.reservation_system.applications.usecases.hotel;

import com.igor.reservation_system.core.entities.Hotel;

import java.util.List;

public interface GetHotelsByLocationUseCase {

    List<Hotel> getHotelsByLocationUseCase(String location);

}
