package com.santana.api.vehicle.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class VehicleException extends IllegalArgumentException {

    private final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public VehicleException(String message) {
        super(message);
    }
}
