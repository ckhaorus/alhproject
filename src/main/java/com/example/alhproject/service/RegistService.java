package com.example.alhproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alhproject.mapper.RegistMapper;

@Service
public class RegistService {
	@Autowired
	private RegistMapper registMapper;

	public void registUser(String loginId, String userName, String password) {
		//return userDtoFactory.create(userMapper.getUser(loginId, CipherUtil.encrypt(password)));
		registMapper.registUser(loginId, userName,password);
	}
}