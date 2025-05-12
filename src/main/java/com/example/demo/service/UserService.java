package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();

    User getUserId(Long id);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);
}
