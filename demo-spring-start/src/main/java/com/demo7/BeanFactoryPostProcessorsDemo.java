package com.demo7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description BeanFactoryPostProcessorsDemo
 * @date 2022/9/2
 */
public class BeanFactoryPostProcessorsDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
		context.refresh();
	}
}
