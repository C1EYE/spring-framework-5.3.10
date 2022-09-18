package com.demo1;

import com.demo1.config.AppConfig;
import com.demo1.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description TransactionalDemo
 * @date 2022/9/15
 */
public class TransactionalDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = (UserService) context.getBean("userService");
		userService.a();
	}
}
