package com.demo13;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description 容器关闭
 * @date 2022/9/7
 */
public class CloseDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
		// (inferred)
		builder.setDestroyMethodName("(inferred)");
		builder.getBeanDefinition().setBeanClass(BeanA.class);
		context.registerBeanDefinition("beanA",builder.getBeanDefinition());
		context.refresh();
		context.close();
	}
}
