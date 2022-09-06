package com.demo11;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description AutowireModeDemo
 * @date 2022/9/6
 */
public class AutowireModeDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanB.class);
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
		builder.setAutowireMode(Autowire.BY_TYPE.value());
		builder.getBeanDefinition().setBeanClass(BeanA.class);
		context.registerBeanDefinition("beanA",builder.getBeanDefinition());
		context.refresh();
	}
}
