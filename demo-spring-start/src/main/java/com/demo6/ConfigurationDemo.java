package com.demo6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description ConfigurationDemo
 * @date 2022/9/3
 */
public class ConfigurationDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ConfigA.class);
		context.refresh();
	}
}
