package com.thoughtworks.training.springboottodolist.controller;

import com.thoughtworks.training.springboottodolist.model.User;
import com.thoughtworks.training.springboottodolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public User add(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logIn(@RequestBody User user, HttpServletResponse response) {
//        User user1 = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(user);
        String token = userService.isLogIn(user);
        response.addHeader("Authentication", token);
        return token;
    }
}
