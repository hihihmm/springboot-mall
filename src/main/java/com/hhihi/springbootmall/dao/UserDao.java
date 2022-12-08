package com.hhihi.springbootmall.dao;

import com.hhihi.springbootmall.dto.UserLoginRequest;
import com.hhihi.springbootmall.dto.UserRegisterRequest;
import com.hhihi.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);
    User getUserByEmail(String email);
    Integer createUser(UserRegisterRequest userRegisterRequest);
}
