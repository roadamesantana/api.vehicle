package com.santana.api.vehicle.util;

import com.santana.api.vehicle.exception.HeaderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;

public class HandlerExceptionsTest implements AutoCloseable {

    @InjectMocks
    HandlerExceptions handlerExceptions;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Override
    public void close() {}

    @Test
    @DisplayName("Simple test ")
    void test() {
        final HttpStatus expected = HttpStatus.BAD_REQUEST;

        final ResponseEntity<String> actual = handlerExceptions.handleHeaderException(new HeaderException(""));

        assertEquals(expected, actual.getStatusCode());
    }
}
