package com.demo9;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description ConstructorDemo
 * @date 2022/9/6
 */
public class ConstructorDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanA.class);
		context.register(BeanB.class);
		context.refresh();
		System.out.println(context.getBean("beanA"));
	}
}
