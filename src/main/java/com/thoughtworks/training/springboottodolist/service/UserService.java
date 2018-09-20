package com.thoughtworks.training.springboottodolist.service;

import com.thoughtworks.training.springboottodolist.model.TokenGenerator;
import com.thoughtworks.training.springboottodolist.model.User;
import com.thoughtworks.training.springboottodolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    private HashMap<String, Long> sessionUserId = new HashMap<>();

    public User addUser(User user) {
        if (userRepository.findByName(user.getName()) == null) {
            return userRepository.save(user);
        }
        return user;
    }

    public String isLogIn(User user) {
        User user1 = userRepository.findByName(user.getName());
        String token = new TokenGenerator().generateToken(user1.getName());
        if (user != null && user.getPassword().equals(user.getPassword())) {
            return tokenService.createToken(user);
        }
        return "login failed!";
    }
}
