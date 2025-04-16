package fi.haagahelia.courseproject.service;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import java.security.Key;

@Component
public class JwtService {

    //Generate secret key for demo purposes.
    static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    //1 day in ms.
    static final long EXPIRATIONTIME = 3600000;

    static final String PREFIX = "Bearer";

    //Generate signed JWT token
    public String getToken(String username) {
        String token = Jwts.builder()
            .setSubject(username)
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
            .signWith(key)
            .compact();

            return token;
    }

    //Get a token from request Authorization header, verify the token and get username
    public String getAuthUser(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(token != null) {
            String user = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token.replace(PREFIX, ""))
                .getBody()
                .getSubject();
    
                if(user != null) {
                    return user;
                }
        }
        return null;
    }

}
