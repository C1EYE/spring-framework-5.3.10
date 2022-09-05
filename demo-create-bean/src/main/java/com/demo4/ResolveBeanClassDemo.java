package com.demo4;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description Demo
 * @date 2022/9/5
 */
public class ResolveBeanClassDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		beanDefinition.setBeanClassName("com.demo4.BeanA");
		context.registerBeanDefinition("beanA", beanDefinition);
		context.refresh();
		Object beanA = context.getBean("beanA");
		System.out.println(beanA);
	}
}
