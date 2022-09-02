package com.demo6;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Yuan
 * @description UserService
 * @date 2022/9/2
 */
public class UserService implements ApplicationContextAware {

	@Override
	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("调用了setApplicationContext");
	}
}
