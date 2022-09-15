package com.demo1.service;

import com.demo1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yuan
 * @description UserService
 * @date 2022/9/15
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Transactional(rollbackFor = Exception.class)
	public void m1(){
		userMapper.insert("m1");
		throw new RuntimeException();
	}

	@Transactional
	public void m2(){
		userMapper.insert("m2");
	}
}
