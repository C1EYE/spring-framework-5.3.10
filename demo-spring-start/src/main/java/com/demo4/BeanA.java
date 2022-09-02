package com.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/2
 */
public class BeanA {

	private UserService userService;

	@Autowired
	@Qualifier("a")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
