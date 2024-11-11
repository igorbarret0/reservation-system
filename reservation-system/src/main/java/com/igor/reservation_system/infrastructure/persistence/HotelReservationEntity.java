package com.igor.reservation_system.infrastructure.persistence;

import com.igor.reservation_system.core.enums.ReservationStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_hotels_reservations")
public class HotelReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long hotelId;

    private Long userId;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private int roomsReserved;

    private ReservationStatus reservationStatus;

    public HotelReservationEntity() {}

    public HotelReservationEntity(Long id, Long hotelId, Long userId, LocalDate checkInDate, LocalDate checkOutDate, int roomsReserved, ReservationStatus reservationStatus) {
        this.id = id;
        this.hotelId = hotelId;
        this.userId = userId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomsReserved = roomsReserved;
        this.reservationStatus = reservationStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getRoomsReserved() {
        return roomsReserved;
    }

    public void setRoomsReserved(int roomsReserved) {
        this.roomsReserved = roomsReserved;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
