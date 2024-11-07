package com.igor.reservation_system.applications.exceptions;

public class InsufficientSeatsAvailableException extends RuntimeException{

    public InsufficientSeatsAvailableException(String message) {
        super(message);
    }

}
