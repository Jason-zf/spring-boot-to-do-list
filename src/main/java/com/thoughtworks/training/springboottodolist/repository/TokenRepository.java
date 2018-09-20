package com.thoughtworks.training.springboottodolist.repository;

import com.thoughtworks.training.springboottodolist.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class TokenRepository {
    private HashMap<String, Long> tokens = new HashMap<>();

    public String createToken(User user) {
        String token = UUID.randomUUID().toString();
        tokens.put(token, user.getId());
        return token;
    }
}
