package com.thoughtworks.training.springboottodolist.service;


import com.thoughtworks.training.springboottodolist.model.Token;
import com.thoughtworks.training.springboottodolist.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TokenServce {
    private List<Token> tokens = new ArrayList<>();

    public TokenServce() {
        this.tokens.add(new Token("d0e65736-687d-4bf6-9987-677258311f05", 1L));
    }

    public Token createToken(User user) {
//        Token token = new Token(UUID.randomUUID().toString(), user.getId());
        Token token = new Token("d0e65736-687d-4bf6-9987-677258311f05", user.getId());
        tokens.add(token);
        return token;
    }

    public Token findByName(String name) {
        return tokens.stream().filter(token -> token.getName().equals(name)).findFirst().get();
    }
}
