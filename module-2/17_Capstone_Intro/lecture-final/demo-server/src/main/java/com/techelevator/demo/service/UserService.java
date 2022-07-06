package com.techelevator.demo.service;

import com.techelevator.demo.dao.UserDao;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Long findIdByUsername(String username) {
        return userDao.findIdByUsername(username);
    }
}
