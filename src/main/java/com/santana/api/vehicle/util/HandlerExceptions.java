package com.santana.api.vehicle.util;

import com.santana.api.vehicle.exception.HeaderException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerExceptions {

    @ExceptionHandler(HeaderException.class)
    public ResponseEntity<String> handleHeaderException(HeaderException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(ex.getMessage());
    }
}
