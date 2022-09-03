package com.demo3;

import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description BeanDefinitionCustomizerDemo
 * @date 2022/9/3
 */
public class BeanDefinitionCustomizerDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		AnnotatedBeanDefinitionReader reader = context.getReader();
		BeanDefinitionCustomizer[] beanDefinitionCustomizers = {new MyBeanDefinitionCustomizer()};
		reader.registerBean(CustomizerBean.class,null,null,beanDefinitionCustomizers);
		context.refresh();
		System.out.println(context.getBean(CustomizerBean.class));
		System.out.println(context.getBean(CustomizerBean.class));
		System.out.println(context.getBean(CustomizerBean.class));
	}
}
