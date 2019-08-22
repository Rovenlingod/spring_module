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
    public Long login(@RequestBody User user){
        if (userService.userChecker(user)){
            return userService.findByLogin(user.getLogin()).getId();
        }
        return Long.parseLong("-1");
    }
}
