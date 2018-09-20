package com.thoughtworks.training.springboottodolist.service;

import com.thoughtworks.training.springboottodolist.model.User;
import com.thoughtworks.training.springboottodolist.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    public String createToken(User user) {
        return tokenRepository.createToken(user);
    }
}
