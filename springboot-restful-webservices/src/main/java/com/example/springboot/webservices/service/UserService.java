package com.example.springboot.webservices.service;

import com.example.springboot.webservices.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userIde);
}
