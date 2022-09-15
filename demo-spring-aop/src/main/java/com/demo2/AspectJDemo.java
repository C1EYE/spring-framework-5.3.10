package com.demo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description AspectJDemo
 * @date 2022/9/15
 */
public class AspectJDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BeanA bean = (BeanA) context.getBean("beanA");
		bean.test1();
	}
}
