package com.igor.reservation_system.infrastructure.mapper;

import com.igor.reservation_system.core.entities.HotelReservation;
import com.igor.reservation_system.core.enums.ReservationStatus;
import com.igor.reservation_system.infrastructure.dtos.HotelReservationRequest;
import com.igor.reservation_system.infrastructure.persistence.HotelReservationEntity;
import org.springframework.stereotype.Component;

@Component
public class HotelReservationMapper {

    public HotelReservation toHotelReservationFromHotelReservationEntity(HotelReservationEntity entity) {

        return new HotelReservation(
          null,
                entity.getHotelId(),
                entity.getUserId(),
                entity.getCheckInDate(),
                entity.getCheckOutDate(),
                entity.getRoomsReserved(),
                entity.getReservationStatus()
        );
    }

    public HotelReservationEntity toHotelReservationEntityFromHotelReservation(HotelReservation reservation) {

        return new HotelReservationEntity(
                null,
                reservation.hotelId(),
                reservation.userId(),
                reservation.checkInDate(),
                reservation.checkOutDate(),
                reservation.roomsReserved(),
                reservation.reservationStatus()
        );
    }

    public HotelReservation toHotelReservationFromHotelReservationRequest(HotelReservationRequest request) {

        return new HotelReservation(
                null,
                request.hotelId(),
                request.userId(),
                request.checkInDate(),
                request.checkOutDate(),
                request.roomsReserved(),
                ReservationStatus.PENDING
        );
    }

}
