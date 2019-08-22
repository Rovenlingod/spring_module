package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RegistrationController {

    private UserService userService;

    @Autowired
    public void setPeopleService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity saveNewUser(@RequestBody User user){
        System.out.println("im here");
        if (userService.loginAndEmailAvailability(user).equals("LOGIN")){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("LOGIN");
        }
        if (userService.loginAndEmailAvailability(user).equals("EMAIL")){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("EMAIL");
        }
        userService.saveUser(new User(user.getLogin(),user.getName(),user.getEmail(),user.getPassword()));
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }
}
