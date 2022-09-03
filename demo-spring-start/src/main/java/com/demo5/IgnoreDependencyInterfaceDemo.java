package com.demo5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description IgnoreDependencyInterfaceDemo
 * @date 2022/9/3
 */
public class IgnoreDependencyInterfaceDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	}
}
