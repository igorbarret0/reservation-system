package com.igor.reservation_system.applications.exceptions;

public class FlightDoesNotExistException extends RuntimeException{

    public FlightDoesNotExistException(String message) {
        super(message);
    }

}
