package com.demo3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description DependsOnDemo
 * @date 2022/9/4
 */
public class DependsOnDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanA.class);
		context.refresh();
		System.out.println(context.getBean("beanA"));
	}
}
