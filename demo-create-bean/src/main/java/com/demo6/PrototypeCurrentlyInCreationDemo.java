package com.demo6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description PrototypeCurrentlyInCreationDemo
 * @date 2022/9/4
 */
public class PrototypeCurrentlyInCreationDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanA.class);
		context.register(BeanB.class);
		context.refresh();
		BeanA beanA = context.getBean(BeanA.class);
	}
}
