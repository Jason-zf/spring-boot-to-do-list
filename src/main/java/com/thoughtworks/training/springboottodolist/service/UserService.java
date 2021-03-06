package com.thoughtworks.training.springboottodolist.service;

import com.thoughtworks.training.springboottodolist.exception.NotFoundException;
import com.thoughtworks.training.springboottodolist.model.User;
import com.thoughtworks.training.springboottodolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    public User addUser(User user) {
        if (userRepository.findByName(user.getName()) == null) {
            return userRepository.save(user);
        }
        return user;
    }

    public String isLogIn(User user) throws NotFoundException {
        User user1 = userRepository.findByName(user.getName());
        if (user1 != null && user.getPassword().equals(user.getPassword())) {
            return tokenService.createToken(user1);
        }
        throw new NotFoundException();
    }

    public User findById(Long userId) {
        return userRepository.findOne(userId);
    }
}
