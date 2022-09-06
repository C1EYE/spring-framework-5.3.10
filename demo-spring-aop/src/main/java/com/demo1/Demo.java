package com.demo1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description Demo
 * @date 2022/9/6
 */
public class Demo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		InterfaceA beanA = (InterfaceA)context.getBean("beanA");
		beanA.m1();
	}
}
