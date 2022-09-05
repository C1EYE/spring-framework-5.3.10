package com.demo5;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

/**
 * @author Yuan
 * @description Demo
 * @date 2022/9/5
 */
public class SupplierDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		AbstractBeanDefinition supplierBd = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		supplierBd.setBeanClass(BeanA.class);

		supplierBd.setInstanceSupplier((Supplier<BeanA>) () -> {
			BeanA beanA = new BeanA();
			System.out.println("Supplier: " + beanA);
			return beanA;
		});
		context.registerBeanDefinition("beanA", supplierBd);
		context.refresh();
		System.out.println("Context: "+context.getBean(BeanA.class));
	}
}
