package com.huangkelly.springbootmall.dao;

import com.huangkelly.springbootmall.dto.UserRegisterRequest;
import com.huangkelly.springbootmall.model.User;

public interface UserDao {

	User getUserById(Integer userId);
	
	User getUserByEmail(String email);
	
	Integer createUser(UserRegisterRequest userRegisterRequest);
}
