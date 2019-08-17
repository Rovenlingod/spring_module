package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLoginAndPassword(String login, String password);
    User findByLogin(String login);
    User findById(Long id);
    @Modifying
    @Transactional
    @Query("update User u set u.login = :login, u.password = :password, u.name = :name, u.email = :email where u.id = :id")
    void updateUser(@Param("id") Long id, @Param("login") String login, @Param("password") String password, @Param("name") String name, @Param("email") String email);
}
