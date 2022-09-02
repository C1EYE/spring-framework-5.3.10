package com.demo8;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description ApplicationListenerDemo
 * @date 2022/9/2
 */
public class ApplicationListenerDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ApplicationListenerA.class);
		context.refresh();
	}
}
