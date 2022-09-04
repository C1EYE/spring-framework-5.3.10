package com.demo5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description Demo
 * @date 2022/9/4
 */
public class MergedBeanDefinitionPostProcessorDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanA.class);
		context.register(MyMergedBeanDefinitionPostProcessor.class);
		context.refresh();
		System.out.println(context.getBean(BeanA.class).getName());
	}
}
