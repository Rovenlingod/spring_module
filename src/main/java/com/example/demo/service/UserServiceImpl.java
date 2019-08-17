package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.enums.Response;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Boolean userChecker(User user) {
        User userFromDb = userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
        if (userFromDb != null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
