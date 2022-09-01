package com.demo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

/**
 * @author Yuan
 * @description registerBean 全参演示
 * @date 2022/9/1
 */
public class RegisterBeanDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		Supplier<BeanA> supplier = new Supplier<BeanA>() {
			@Override
			public BeanA get() {
				BeanA beanA = new BeanA();
				System.out.println("Supplier: " + beanA);
				return beanA;
			}
		};
		MyBeanDefinitionCustomizer customizer = new MyBeanDefinitionCustomizer();
		context.registerBean("beanA", BeanA.class, supplier);
		context.refresh();
		System.out.println(context.getBean("beanA"));
		System.out.println(context.getBean("beanA"));
		System.out.println(context.getBean("beanA"));
	}
}
