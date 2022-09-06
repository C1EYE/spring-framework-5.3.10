package com.demo12;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description ResolveDependency
 * @date 2022/9/6
 */
public class ResolveDependencyDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanA.class);

		BeanDefinitionBuilder builderB1 = BeanDefinitionBuilder.genericBeanDefinition();
		builderB1.getBeanDefinition().setBeanClass(BeanB.class);
		context.registerBeanDefinition("beanB1", builderB1.getBeanDefinition());

		BeanDefinitionBuilder builderB2 = BeanDefinitionBuilder.genericBeanDefinition();
		builderB2.getBeanDefinition().setBeanClass(BeanB.class);
		context.registerBeanDefinition("beanB2", builderB2.getBeanDefinition());

		context.refresh();


	}
}
