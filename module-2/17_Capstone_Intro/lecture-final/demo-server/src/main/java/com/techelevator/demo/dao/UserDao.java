package com.techelevator.demo.dao;

import com.techelevator.demo.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findByUsername(String username);

    Long findIdByUsername(String username);

    boolean create(String username, String password);
}
