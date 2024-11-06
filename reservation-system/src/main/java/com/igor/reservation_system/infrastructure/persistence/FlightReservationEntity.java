package com.igor.reservation_system.infrastructure.persistence;

import com.igor.reservation_system.core.enums.ReservationStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_flight_reservations")
public class FlightReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long flightId;

    private Long userId;

    private LocalDateTime reservationDate;

    private Integer seatsReserved;

    private ReservationStatus reservationStatus;

    public FlightReservationEntity() {}

    public FlightReservationEntity(Long id, Long flightId, Long userId, LocalDateTime reservationDate, Integer seatsReserved, ReservationStatus reservationStatus) {
        this.id = id;
        this.flightId = flightId;
        this.userId = userId;
        this.reservationDate = reservationDate;
        this.seatsReserved = seatsReserved;
        this.reservationStatus = reservationStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Integer getSeatsReserved() {
        return seatsReserved;
    }

    public void setSeatsReserved(Integer seatsReserved) {
        this.seatsReserved = seatsReserved;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
