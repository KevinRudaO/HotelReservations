package com.hotel.reservarions.hotel.application.domain.businessException;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
