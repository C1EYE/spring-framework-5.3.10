package com.demo4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description ResolveBeforeInstantiationDemo
 * @date 2022/9/4
 */
public class ResolveBeforeInstantiationDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanA.class);
		context.register(MyInstantiationAwareBeanPostProcessor.class);
		context.register(MyBeanPostProcessor.class);
		context.refresh();
		System.out.println(context.getBean("beanA"));
	}
}
