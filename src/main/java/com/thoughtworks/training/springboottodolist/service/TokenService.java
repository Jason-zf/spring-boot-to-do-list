package com.thoughtworks.training.springboottodolist.service;

import com.thoughtworks.training.springboottodolist.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Map;

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
            Map<String, Object> claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(signature)
                    .getBody();
            return new Long((Integer) claims.get("user_id"));
        } catch (RuntimeException e) {
            return null;
        }

    }
}
