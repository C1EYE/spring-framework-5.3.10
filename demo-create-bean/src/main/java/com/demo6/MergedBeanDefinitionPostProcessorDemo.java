package com.demo6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description Demo
 * @date 2022/9/5
 */
public class MergedBeanDefinitionPostProcessorDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanA.class);
		context.register(MyMergedBeanDefinitionPostProcessor.class);
		context.refresh();
		BeanA bean = context.getBean(BeanA.class);
		System.out.println(bean.getName());
	}
}
