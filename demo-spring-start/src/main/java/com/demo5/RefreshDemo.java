package com.demo5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Yuan
 * @description RefreshDemo
 * @date 2022/9/2
 */
public class RefreshDemo {
	public static void main(String[] args) {
		// 不支持重复刷新
		AnnotationConfigApplicationContext noRefreshContext = new AnnotationConfigApplicationContext();
		noRefreshContext.refresh();
		// 支持重复刷新
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
		context.refresh();
		context.refresh();
	}
}
