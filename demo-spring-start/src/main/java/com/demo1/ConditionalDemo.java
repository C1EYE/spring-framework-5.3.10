package com.demo1;

import com.demo1.config.AppConfig;
import com.demo1.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;

/**
 * @author Yuan
 * @description 演示 @Conditional 注解
 * @date 2022/9/1
 */
public class ConditionalDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		userService.test();
		ConfigurationClassPostProcessor processor = new ConfigurationClassPostProcessor();
		processor.processConfigBeanDefinitions(context);
	}
}
