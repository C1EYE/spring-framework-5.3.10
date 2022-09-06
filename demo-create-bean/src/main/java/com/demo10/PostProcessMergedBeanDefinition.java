package com.demo10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description PostProcessMergedBeanDefinition
 * @date 2022/9/6
 */
public class PostProcessMergedBeanDefinition {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AutoInjectBeanPostProcessors.class);
		context.register(BeanA.class);
		context.register(BeanB.class);
		context.refresh();
	}
}
