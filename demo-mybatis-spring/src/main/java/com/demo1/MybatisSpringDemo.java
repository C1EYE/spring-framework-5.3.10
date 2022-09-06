package com.demo1;

import com.demo1.config.AppConfig;
import com.demo1.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description MybatisSpringDemo
 * @date 2022/9/6
 */
public class MybatisSpringDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService bean = context.getBean(UserService.class);
//		bean.getName();
	}
}
