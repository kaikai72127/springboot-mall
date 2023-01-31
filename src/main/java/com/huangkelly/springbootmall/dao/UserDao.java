package com.huangkelly.springbootmall.dao;

import com.huangkelly.springbootmall.dto.UserRegisterRequest;
import com.huangkelly.springbootmall.model.User;

public interface UserDao {

	User getUserById(Integer userId);
	
	Integer createUser(UserRegisterRequest userRegisterRequest);
}
