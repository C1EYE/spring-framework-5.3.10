package com.demo4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description ScopedProxyDemo
 * @date 2022/9/3
 */
public class ScopedProxyDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ScopedProxyBeanA.class);
		context.register(ScopedProxyBeanB.class);
		context.refresh();
		ScopedProxyBeanA beanA = context.getBean(ScopedProxyBeanA.class);
		beanA.testScope();
		beanA.testScope();
		beanA.testScope();
	}
}
