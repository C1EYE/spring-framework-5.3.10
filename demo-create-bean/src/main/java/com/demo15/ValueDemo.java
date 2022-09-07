package com.demo15;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author Yuan
 * @description ValueDemo
 * @date 2022/9/7
 */
public class ValueDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.register(BeanA.class);
		context.refresh();
		ConfigurableEnvironment environment = context.getEnvironment();
		System.out.println(environment);
	}
}
