package com.santana.api.vehicle.util;

import com.santana.api.vehicle.exception.HeaderException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Component
@Scope(value = "singleton")
public class HeaderUtil {
    public String getHeaderField(String fieldName, HttpServletRequest request) throws HeaderException {
        if (Objects.isNull(fieldName) || fieldName.isBlank()) {
            throw new HeaderException("Invalid header name");
        }

        final String fieldValue = request.getHeader(fieldName);
        if (Objects.isNull(fieldValue) || fieldValue.isBlank()) {
            throw new HeaderException("Invalid header value for field ".concat(fieldName));
        }

        return fieldValue;
    }
}
