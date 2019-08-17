package com.example.demo.controller;


import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setPeopleService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public List<User> showAllUsers(){
        return userService.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void addUser(){
        userService.saveUser(new User("god", "jesus", "jesus@mail.ru", "imsatan"));
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public void deleteAll(){
        userService.deleteAll();
    }



}
