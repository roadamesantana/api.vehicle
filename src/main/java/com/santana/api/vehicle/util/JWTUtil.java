package com.santana.api.vehicle.util;

import com.santana.api.vehicle.exception.HeaderException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Scope(value = "singleton")
public class JWTUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    private HeaderUtil headerUtil;

    public String getUsernameFromRequest(HttpServletRequest request) {
        final String token = headerUtil.getHeaderField("x-token", request);
        final Claims claimsFromToken = getAllClaimsFromToken(token);

        validateExpirationToken(claimsFromToken.getExpiration());

        return claimsFromToken.getSubject();
    }

    private Claims getAllClaimsFromToken(String token) {
        validateToken(token);

        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (SignatureException se) {
            throw new HeaderException("Invalid Token");
        } catch (Exception e) {
            throw e;
        }
    }

    private void validateExpirationToken(Date expiration) {
        if (null == expiration) {
            throw new HeaderException("Invalid Token");
        }

        if (expiration.before(new Date())) {
            throw new HeaderException("Expired Token");
        }
    }

    private void validateToken(String token) {
        if (null == token || token.isBlank()) {
            throw new HeaderException("Invalid Token");
        }
    }
}
