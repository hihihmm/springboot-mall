package com.hhihi.springbootmall.service;

import com.hhihi.springbootmall.dto.UserRegisterRequest;
import com.hhihi.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);
    Integer register(UserRegisterRequest userRegisterRequest);
}
