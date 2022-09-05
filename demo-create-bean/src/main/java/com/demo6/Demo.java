package com.demo6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description Demo
 * @date 2022/9/5
 */
public class Demo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanA.class);
		context.register(BeanB.class);
		context.refresh();
		System.out.println(context.getBean(BeanA.class));
	}
}
