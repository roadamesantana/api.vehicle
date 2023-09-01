package com.santana.api.vehicle.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Component
public class HeaderUtil {
    public String getHeaderField(String fieldName, HttpServletRequest request) throws Exception {
        if (Objects.isNull(fieldName) || fieldName.isBlank()) {
            throw new Exception("Invalid header name");
        }

        final String fieldValue = request.getHeader(fieldName);
        if (Objects.isNull(fieldValue) || fieldValue.isBlank()) {
            throw new Exception("Invalid header value for field ".concat(fieldName));
        }

        return fieldValue;
    }
}
