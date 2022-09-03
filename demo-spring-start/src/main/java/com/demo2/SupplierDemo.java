package com.demo2;

import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

/**
 * @author Yuan
 * @description SupplierDemo
 * @date 2022/9/3
 */
public class SupplierDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		AnnotatedBeanDefinitionReader reader = context.getReader();

		Supplier<SupplierDemo> supplier = () -> {
			SupplierDemo supplierDemo = new SupplierDemo();
			System.out.println("Supplier get 创建" + supplierDemo);
			return supplierDemo;
		};

		reader.registerBean(SupplierDemo.class, supplier);
		context.refresh();
		System.out.println("容器获取的："+context.getBean(SupplierDemo.class));
	}
}
