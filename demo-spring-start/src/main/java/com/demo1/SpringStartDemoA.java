package com.demo1;

import com.demo1.config.AppConfig;
import com.demo1.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description SpringStartDemoA
 * @date 2022/9/1
 */
public class SpringStartDemoA {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		userService.test();
	}
}
