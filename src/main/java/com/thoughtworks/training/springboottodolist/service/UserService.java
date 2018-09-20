package com.thoughtworks.training.springboottodolist.service;

import com.thoughtworks.training.springboottodolist.model.User;
import com.thoughtworks.training.springboottodolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenServce tokenServce;

    public User addUser(User user) {
        if (userRepository.findByName(user.getName()) == null) {
            return userRepository.save(user);
        }
        return user;
    }

    public String isLogIn(User user) {
        User user1 = userRepository.findByName(user.getName());
        if (user1 != null && user.getPassword().equals(user.getPassword())) {
            return tokenServce.createToken(user1).getName();
        }
        return "login failed";
    }

    public User findById(Long userId) {
        return userRepository.findOne(userId);
    }
}
