package com.opensite.dao;

import com.opensite.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}
