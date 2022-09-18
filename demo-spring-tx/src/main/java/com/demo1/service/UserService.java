package com.demo1.service;

import com.demo1.mapper.UserMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(rollbackFor = NullPointerException.class)
	public void m1(){
		userMapper.insert("m1");
		UserService proxy = (UserService)AopContext.currentProxy();
		try {
			proxy.m2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void m2(){
		userMapper.insert("m2");
//		throw new RuntimeException();
	}
}
