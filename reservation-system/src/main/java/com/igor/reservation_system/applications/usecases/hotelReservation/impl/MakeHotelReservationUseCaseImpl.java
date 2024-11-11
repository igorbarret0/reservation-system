package com.igor.reservation_system.applications.usecases.hotelReservation.impl;

import com.igor.reservation_system.applications.exceptions.HotelNotFoundException;
import com.igor.reservation_system.applications.exceptions.InvalidScheduleReservationException;
import com.igor.reservation_system.applications.exceptions.UserNotFoundException;
import com.igor.reservation_system.applications.usecases.hotelReservation.MakeHotelReservationUseCase;
import com.igor.reservation_system.core.entities.HotelReservation;
import com.igor.reservation_system.core.gateways.HotelGateway;
import com.igor.reservation_system.core.gateways.HotelReservationGateway;
import com.igor.reservation_system.core.gateways.UserGateway;

import java.time.LocalDate;

public class MakeHotelReservationUseCaseImpl implements MakeHotelReservationUseCase {

    private HotelReservationGateway hotelReservationGateway;
    private HotelGateway hotelGateway;
    private UserGateway userGateway;

    public MakeHotelReservationUseCaseImpl(HotelReservationGateway hotelReservationGateway, UserGateway userGateway, HotelGateway hotelGateway) {
        this.hotelReservationGateway = hotelReservationGateway;
        this.userGateway = userGateway;
        this.hotelGateway = hotelGateway;
    }

    @Override
    public void makeHotelReservationUseCase(HotelReservation hotelReservation) {

        if (userGateway.getUserById(hotelReservation.userId()) == null) {
            throw new UserNotFoundException("Could not found User with the provided ID: " + hotelReservation.userId());
        }

        if (hotelGateway.getHotelById(hotelReservation.hotelId()) == null) {
            throw new HotelNotFoundException("Could not found Hotel with the provided ID: " + hotelReservation.hotelId());
        }

        LocalDate now = LocalDate.now();
        if (hotelReservation.checkInDate().isBefore(now)) {
            throw new InvalidScheduleReservationException("The check-in date cannot be in the past");
        }

        if (hotelReservation.checkOutDate().isBefore(now)) {
            throw new InvalidScheduleReservationException("The check-out date cannot be in the past");
        }

        hotelGateway.updateAvailableRooms(hotelReservation.hotelId(), hotelReservation.roomsReserved());

        hotelReservationGateway.makeHotelReservation(hotelReservation);
    }
}
