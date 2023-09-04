package com.santana.api.vehicle.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HeaderException extends IllegalArgumentException {

    private final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public HeaderException(String message) {
        super(message);
    }
}
