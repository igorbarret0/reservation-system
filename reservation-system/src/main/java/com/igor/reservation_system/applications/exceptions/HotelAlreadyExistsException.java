package com.igor.reservation_system.applications.exceptions;

public class HotelAlreadyExistsException extends RuntimeException{

    public HotelAlreadyExistsException(String message) {
        super(message);
    }

}
