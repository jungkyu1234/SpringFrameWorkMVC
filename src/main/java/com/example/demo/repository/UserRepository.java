package com.example.demo.repository;

import com.example.demo.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User findById(Long id);

    boolean existsEmail(String email);

    User save(User user);

    User update(User user);

    void deleteById(Long id);
}
