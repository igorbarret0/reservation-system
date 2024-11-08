package com.igor.reservation_system.infrastructure.mapper;

import com.igor.reservation_system.core.entities.FlightReservation;
import com.igor.reservation_system.core.enums.ReservationStatus;
import com.igor.reservation_system.infrastructure.dtos.FlightReservationRequest;
import com.igor.reservation_system.infrastructure.persistence.FlightReservationEntity;
import org.springframework.stereotype.Component;

@Component
public class FlightReservationMapper {

    public FlightReservation toFlightReservationEntityFromFlightReservationEntity(FlightReservationEntity entity) {

        return new FlightReservation(
          null,
                entity.getFlightId(),
                entity.getUserId(),
                entity.getReservationDate(),
                entity.getSeatsReserved(),
                entity.getReservationStatus()
        );
    }

    public FlightReservationEntity toFlightReservationEntityFromFlightReservationEntity(FlightReservation reservation) {

        return new FlightReservationEntity(
          null,
          reservation.flightId(),
          reservation.userId(),
          reservation.reservationDate(),
          reservation.seatsReserved(),
          reservation.reservationStatus()
        );
    }

    public FlightReservation toFlightReservationFromFlightReservationRequest(FlightReservationRequest request) {

        return new FlightReservation(
          null,
                request.flightId(),
                request.userId(),
                request.reservationDate(),
                request.seatsReserved(),
                ReservationStatus.PENDING
        );
    }

    public FlightReservation toFlightReservationFromFlightReservationEntity(FlightReservationEntity entity) {

        return new FlightReservation(
                null,
                entity.getFlightId(),
                entity.getUserId(),
                entity.getReservationDate(),
                entity.getSeatsReserved(),
                entity.getReservationStatus()
        );
    }

}
