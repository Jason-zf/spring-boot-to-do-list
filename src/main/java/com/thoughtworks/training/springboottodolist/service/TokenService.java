package com.thoughtworks.training.springboottodolist.service;

import com.thoughtworks.training.springboottodolist.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    public static final String SECRET_KEY = "secret_key";

    public String createToken(User user) {
        String signature = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .claim("user_id", user.getId())
                .compact();
        return signature;
    }

    public Long parseToken(String signature) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(signature)
                    .getBody();
            return claims.get("user_id", Long.class);
        } catch (RuntimeException e) {
            return null;
        }

    }
}
