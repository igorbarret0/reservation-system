package com.igor.reservation_system.applications.exceptions;

public class InvalidScheduleReservationException extends RuntimeException{

    public InvalidScheduleReservationException(String message) {
        super(message);
    }
}
