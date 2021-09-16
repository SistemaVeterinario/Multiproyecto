package com.poli.serviceuser.service;

import com.poli.serviceuser.entities.User;

import java.util.List;

public interface UserService {
    void delete(User user);
    void save(User user);
    List<User> findAll();
    User findById(Long id);
}
