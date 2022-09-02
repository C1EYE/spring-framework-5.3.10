package com.demo4;

import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description QualifierDemo
 * @date 2022/9/2
 */
public class QualifierDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		AnnotatedBeanDefinitionReader reader = context.getReader();
		reader.registerBean(UserService.class);
		reader.registerBean(BeanA.class);
//		reader.registerBean(BeanB.class);
		context.refresh();
		System.out.println(context.getBean(UserService.class));
		System.out.println(context.getBean(BeanA.class));
//		System.out.println(context.getBean(BeanB.class));
	}
}
