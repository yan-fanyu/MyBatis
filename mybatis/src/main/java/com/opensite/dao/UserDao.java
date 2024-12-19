package com.opensite.dao;

import com.opensite.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(Integer id);
    void deleteById(Integer id);
    void add(User user);
}
