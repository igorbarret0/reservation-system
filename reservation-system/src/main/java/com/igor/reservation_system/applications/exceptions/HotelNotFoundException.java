package com.igor.reservation_system.applications.exceptions;

public class HotelNotFoundException extends RuntimeException{

    public HotelNotFoundException(String message) {
        super(message);
    }

}
