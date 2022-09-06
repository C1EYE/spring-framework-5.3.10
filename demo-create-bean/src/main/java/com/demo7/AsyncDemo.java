package com.demo7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description AsyncDemo
 * @date 2022/9/6
 */
public class AsyncDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.register(BeanA.class);
		context.register(BeanB.class);
		context.refresh();
		BeanA beanA = (BeanA)context.getBean("beanA");
		beanA.test();
	}
}
