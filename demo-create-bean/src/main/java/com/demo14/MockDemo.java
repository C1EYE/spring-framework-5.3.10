package com.demo14;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description MockDemo
 * @date 2022/9/7
 */
public class MockDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanB.class);
		context.register(MockBeanPostProcessor.class);
		context.refresh();
		InterfaceB bean = context.getBean(InterfaceB.class);
		bean.getUser();
	}
}
