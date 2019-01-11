package com.example.service.service;

import com.example.service.model.User;

import java.util.List;

public interface UserService {
    User findById(String id);
    List<User> list();
    boolean modifyName(User user);
    boolean delete(String id);
    boolean addUser(User user);
}
