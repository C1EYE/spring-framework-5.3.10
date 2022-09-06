package com.demo1.service;

import com.demo1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yuan
 * @description UserService
 * @date 2022/9/6
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public String getName() {
		String name = userMapper.selectName();
		System.out.println("getName: " + name);
		return name;
	}
}
