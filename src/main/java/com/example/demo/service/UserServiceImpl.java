package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
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

    @Override
    public void updateUserById(Long id, User user) {
        User userFromDb = userRepository.findById(id);
        if (!user.getLogin().isEmpty()){userFromDb.setLogin(user.getLogin());}
        if (!user.getPassword().isEmpty()){userFromDb.setPassword(user.getPassword());}
        if (!user.getName().isEmpty()){userFromDb.setName(user.getName());}
        if (!user.getEmail().isEmpty()){userFromDb.setEmail(user.getEmail());}
        userRepository.updateUser(userFromDb.getId(), userFromDb.getLogin(), userFromDb.getPassword(), userFromDb.getName(), userFromDb.getEmail());
    }

    @Override
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public String loginAndEmailAvailability(User user){
        if (userRepository.findByLogin(user.getLogin()) != null){
            return "LOGIN";
        }
        if (userRepository.findByEmail(user.getEmail()) != null){
            return "EMAIL";
        }
        return "OK";
    }
}
