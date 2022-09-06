package com.demo7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description Demo
 * @date 2022/9/6
 */
public class Demo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(MyContextRefreshedListener.class);
		context.refresh();
	}
}
