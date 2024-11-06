package com.igor.reservation_system.applications.exceptions;

public class PhoneNumberAlreadyExistException extends RuntimeException{

    public PhoneNumberAlreadyExistException(String message) {
        super(message);
    }

}
