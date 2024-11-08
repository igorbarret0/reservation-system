package com.igor.reservation_system.applications.exceptions;

public class ReservationNotFoundException extends RuntimeException {

    public ReservationNotFoundException(String message) {
        super(message);
    }

}
