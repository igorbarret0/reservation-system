package com.igor.reservation_system.core.gateways;

import com.igor.reservation_system.core.entities.Hotel;

import java.util.List;

public interface HotelGateway {

    Hotel saveHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotelById(Long id);

    List<Hotel> getHotelsByLocation(String location);

    boolean existsHotelByName(String name);

    void updateTotalRooms(Long hotelId, int roomsReserved);

}
