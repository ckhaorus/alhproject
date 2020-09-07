package com.example.alhproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alhproject.dto.UserDto;
import com.example.alhproject.dto.factory.UserDtoFactory;
import com.example.alhproject.mapper.UserMapper;

@Service
public class LoginService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserDtoFactory userDtoFactory;

	public UserDto getUser(String loginId, String password) {
		//return userDtoFactory.create(userMapper.getUser(loginId, CipherUtil.encrypt(password)));
		return userDtoFactory.create(userMapper.getUser(loginId, password));
	}

}