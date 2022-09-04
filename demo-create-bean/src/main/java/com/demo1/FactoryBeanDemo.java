package com.demo1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description FactoryBeanDemo
 * @date 2022/9/4
 */
public class FactoryBeanDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanA.class);
		context.refresh();
		System.out.println(context.getBean("beanA"));
		System.out.println(context.getBean("&beanA"));
	}
}
