package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {
    private UserService userService;

    @Autowired
    public void setPeopleService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Boolean login(@RequestBody User user){
        System.out.println("got to login");
        return userService.userChecker(user);
    }

    @RequestMapping(value = "/login1", method = RequestMethod.POST)
    public User login1(@RequestBody User user){
        System.out.println("got to login1");
        return user;
    }
}
