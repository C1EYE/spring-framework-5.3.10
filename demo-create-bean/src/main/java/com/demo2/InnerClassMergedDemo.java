package com.demo2;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description 内部类 beanDefinition 合并演示
 * @date 2022/9/4
 */
public class InnerClassMergedDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanB.class);
		context.refresh();
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		System.out.println(context.getBean("beanB"));
		System.out.println(context.getBean("beanC"));
		System.out.println(context.getBean("beanC"));
	}
}
