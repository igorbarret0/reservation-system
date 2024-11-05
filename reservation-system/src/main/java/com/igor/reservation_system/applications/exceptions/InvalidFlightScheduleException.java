package com.igor.reservation_system.applications.exceptions;

public class InvalidFlightScheduleException extends RuntimeException {

    public InvalidFlightScheduleException(String message) {
        super(message);
    }

}
