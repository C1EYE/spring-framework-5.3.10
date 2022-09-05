package com.demo4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description Demo
 * @date 2022/9/5
 */
public class PrepareMethodOverridesDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.register(BeanB.class);
		context.refresh();
		BeanA beanA = context.getBean("beanA",BeanA.class);
		beanA.test();
		beanA.test("demo");
	}
}
