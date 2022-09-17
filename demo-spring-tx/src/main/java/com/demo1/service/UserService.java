package com.demo1.service;

import com.demo1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yuan
 * @description UserService
 * @date 2022/9/15
 */
@Service
public class UserService implements IUserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public void m1(){
		userMapper.insert("m1");
		throw new RuntimeException();
	}

	public void m2(){
		userMapper.insert("m2");
	}
}
