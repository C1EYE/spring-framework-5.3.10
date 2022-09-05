package com.demo5;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description FactoryMethodName
 * @date 2022/9/5
 */
public class FactoryMethodNameDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		AbstractBeanDefinition factoryMethodNameBd = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		factoryMethodNameBd.setBeanClass(BeanA.class);
		factoryMethodNameBd.setFactoryMethodName("ssBeanA");
		context.refresh();
		context.registerBeanDefinition("beanA",factoryMethodNameBd);
		System.out.println("Context: "+context.getBean("beanA"));
	}
}
