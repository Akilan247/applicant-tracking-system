package com.akilan.application_tracking_system.Auth;
//package com.example.Application_Management_System.AuthUtil;

//import com.example.Application_Management_System.ApplicationManagementSystemApplication;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.akilan.application_tracking_system.Service.CustomUserDetailsService;

import javax.crypto.SecretKey;

import java.util.Collection;
import java.util.Date;

@Component
public class JWTUtil {

    @Autowired
    CustomUserDetailsService userDetailsService;

    private final String SECRET = "my-secret-key-that-is-long-enough-1234567890!@#";
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());
    private final long EXPIRATION_TIME = 1000 * 60 * 30;

    public String generateToken(String username) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        System.out.println(userDetails.toString());
        String role = "ROLE_USER";

        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        System.out.println(authorities.toString());
        if (authorities != null && !authorities.isEmpty()) {
            for (GrantedAuthority authority : authorities) {

                String auth = authority.getAuthority();

                if (auth.startsWith("ROLE_")) {
                    role = auth.toUpperCase(); // normalize to ROLE_ADMIN etc.
                    break;
                } else {
                    role = auth;
                }
            }
        }
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role) 
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        System.out.println("In extracting username");

        return extractClaims(token).getSubject();
    }

    private Claims extractClaims(String token) {
       
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String username, UserDetails userDetails, String token) {

        return username.equalsIgnoreCase(userDetails.getUsername().toLowerCase()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        System.out.println("isTokenExpired...");
        return extractClaims(token).getExpiration().before(new Date());
    }
}
