package com.santana.api.vehicle.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.openMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.test.context.ActiveProfiles;

import javax.servlet.http.HttpServletRequest;

@ActiveProfiles("VehicleTestProfile")
public class HeaderUtilTest implements AutoCloseable {

    @InjectMocks
    HeaderUtil headerUtil;

    @Spy
    HttpServletRequest request;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Override
    public void close() {}

    @Test
    @DisplayName("Simple test has userId")
    void testHasUserId() throws Exception {
        final String expected = "user";

        doReturn("user").when(request).getHeader("user");

        final String actual = headerUtil.getHeaderField("user", request);

        assertEquals(expected, actual);
    }
}
