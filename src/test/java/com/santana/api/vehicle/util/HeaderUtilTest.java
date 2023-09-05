package com.santana.api.vehicle.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.openMocks;

import com.santana.api.vehicle.exception.HeaderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import javax.servlet.http.HttpServletRequest;

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
    @DisplayName("Simple test with userId")
    void testHasUserId() {
        final String expected = "user";

        doReturn("user").when(request).getHeader("user");

        final String actual = headerUtil.getHeaderField("user", request);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid field name")
    void testValidFieldName() {
        final String expected = "Invalid header name";

        Throwable exceptionNull = assertThrows(HeaderException.class, () -> headerUtil.getHeaderField(null, request));
        Throwable exception = assertThrows(HeaderException.class, () -> headerUtil.getHeaderField("", request));

        assertEquals(expected, exceptionNull.getMessage());
        assertEquals(expected, exception.getMessage());
    }

    @Test
    @DisplayName("Invalid field value")
    void testValidFieldValue() {
        final String fieldName = "fieldTestName";
        final String expected = "Invalid header value for field ".concat(fieldName);

        doReturn(null).when(request).getHeader(fieldName);
        Throwable exception = assertThrows(HeaderException.class, () -> headerUtil.getHeaderField(fieldName, request));
        assertEquals(expected, exception.getMessage());

        doReturn("").when(request).getHeader(fieldName);
        exception = assertThrows(HeaderException.class, () -> headerUtil.getHeaderField(fieldName, request));
        assertEquals(expected, exception.getMessage());
    }
}
