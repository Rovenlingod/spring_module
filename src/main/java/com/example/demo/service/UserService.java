package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void saveUser(User user);
    Boolean userChecker(User user);
    void deleteAll();
    void updateUserById(Long id, User user);
    User findByLogin(String login);
    User findByEmail(String email);
    String loginAndEmailAvailability(User user);
}
