package com.demo6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description IgnoreDependencyInterfaceDemo
 * @date 2022/9/2
 */
public class IgnoreDependencyInterfaceDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
	}
}
