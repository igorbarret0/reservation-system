package com.igor.reservation_system.core.gateways;

import com.igor.reservation_system.core.entities.HotelReservation;

public interface HotelReservationGateway {

    void makeHotelReservation(HotelReservation hotelReservation);

    HotelReservation getHotelReservationById(Long id);

}
