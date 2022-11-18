package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public boolean login(String username, String password) {
        return userDao.login(username, password) != null;
    }

    @Override
    public boolean register(String username, String password, String PhoneNumber) {
        return userDao.register(username,password,PhoneNumber)>0;
    }

    @Override
    public User show(String username) {
        return userDao.show(username);
    }
}
