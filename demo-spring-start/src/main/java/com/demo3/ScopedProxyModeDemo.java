package com.demo3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description ScopedProxyModeDemo
 * @date 2022/9/1
 */
public class ScopedProxyModeDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.registerBean(BeanA.class);
		context.registerBean(BeanB.class);
		context.refresh();
//		BeanA beanA = context.getBean(BeanA.class);
//		beanA.test();
//		beanA.test();
//		beanA.test();
	}
}
