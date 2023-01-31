package com.huangkelly.springbootmall.service;

import com.huangkelly.springbootmall.dto.UserRegisterRequest;
import com.huangkelly.springbootmall.model.User;

public interface UserService {

	User getUserById(Integer userId);
	
	Integer register(UserRegisterRequest userRegisterRequest);
	
}
