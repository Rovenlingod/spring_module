package com.example.demo.controller;


import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResponseEntity edit(@RequestBody User user){
        if (userService.loginAndEmailAvailability(user).equals("LOGIN")){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("LOGIN");
        }
        if (userService.loginAndEmailAvailability(user).equals("EMAIL")){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("EMAIL");
        }
        userService.updateUserById(user.getId(), user);
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

}
