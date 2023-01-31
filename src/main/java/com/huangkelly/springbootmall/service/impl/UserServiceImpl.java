package com.huangkelly.springbootmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huangkelly.springbootmall.dao.UserDao;
import com.huangkelly.springbootmall.dto.UserRegisterRequest;
import com.huangkelly.springbootmall.model.User;
import com.huangkelly.springbootmall.service.UserService;

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
