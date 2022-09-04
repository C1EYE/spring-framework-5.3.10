package com.demo2;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description 子父 beanDefinition 合并演示
 * @date 2022/9/4
 */
public class MergedLocalBeanDefinitionDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 父 BeanDefinition
		BeanDefinitionBuilder parentBd = BeanDefinitionBuilder.genericBeanDefinition();
		AbstractBeanDefinition parentBeanDefinition = parentBd.getBeanDefinition();
		parentBeanDefinition.setAbstract(true);
		parentBeanDefinition.setScope(ConfigurableBeanFactory.SCOPE_PROTOTYPE);

		// 子 BeanDefinition
		BeanDefinitionBuilder childBd = BeanDefinitionBuilder.genericBeanDefinition();
		AbstractBeanDefinition childBeanDefinition = childBd.getBeanDefinition();
		childBeanDefinition.setBeanClass(BeanA.class);
		childBeanDefinition.setParentName("parentBd");

		context.registerBeanDefinition("parentBd",parentBeanDefinition);
		context.registerBeanDefinition("childBd",childBeanDefinition);

		context.refresh();
		System.out.println(context.getBean("childBd"));
		System.out.println(context.getBean("childBd"));
		System.out.println(context.getBean("childBd"));
	}
}
