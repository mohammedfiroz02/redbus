package com.redbus.security;
import com.redbus.exception.BlogAPIException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTService {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private int jwtExpirationInMs;

    private static final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Generates a secure key

    public static SecretKey getSigningKey() {
        return key;
    }

    // Generate Token
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expireDate)
                .signWith(getSigningKey()) // ✅ Use SecretKey properly
                .compact();
    }
    /////GEV
    // Extract username from token
    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey()) // ✅ Corrected method
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    // Validate JWT Token
    public boolean validateToken(String token) throws BlogAPIException {
        try {
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            throw new BlogAPIException("JWT token is expired");
        } catch (UnsupportedJwtException ex) {
            throw new BlogAPIException("JWT token is unsupported");
        } catch (MalformedJwtException ex) {
            throw new BlogAPIException("JWT token is invalid");
        } catch (SignatureException ex) {
            throw new BlogAPIException("JWT signature validation failed");
        } catch (IllegalArgumentException ex) {
            throw new BlogAPIException("JWT claims string is empty or null");
        }
    }
}
