package com.maojiu.service.impl;

import com.maojiu.dao.UserDao;
import com.maojiu.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean login(String name, String password) {
        return userDao.login(name, password);
    }
}
