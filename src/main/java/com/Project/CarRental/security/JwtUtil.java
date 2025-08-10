package com.Project.CarRental.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
//    The annotation @Value from org.springframework.beans.factory.annotation.Value is used in Spring to inject values into fields
//    from external sources like:
//    1]application.properties or application.yml
//    2]Environment variables
//    3]System properties

    @Value("${jwt.secret}")
    private String secrete;

    @Value("${jwt.expiration}")
        private long expiration;

    //this will generate token based on user detail
    public String generateToken(String userName){
        return Jwts.builder()
                .setSubject(userName)//setting user name as subject
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(SignatureAlgorithm.HS512,secrete )
                .compact();
    }

    public String extractUsername(String token){
        return Jwts.parser()
                .setSigningKey(secrete)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();//we are getting username which we set it as username
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secrete).parseClaimsJws(token);
            return true;
        }catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }


}
