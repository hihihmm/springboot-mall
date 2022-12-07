package com.hhihi.springbootmall.service.impl;

import com.hhihi.springbootmall.dao.UserDao;
import com.hhihi.springbootmall.dto.UserRegisterRequest;
import com.hhihi.springbootmall.model.User;
import com.hhihi.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}


