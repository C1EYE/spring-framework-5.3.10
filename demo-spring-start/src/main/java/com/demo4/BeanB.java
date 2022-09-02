package com.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Yuan
 * @description BeanB
 * @date 2022/9/2
 */
public class BeanB {
	private UserService userService;

	@Autowired
	@Qualifier("b")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
