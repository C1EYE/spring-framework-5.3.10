package com.demo1;

import com.demo1.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Yuan
 * @description 演示 @Conditional 注解
 * @date 2022/9/1
 */
public class ConditionalDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		System.out.println(context.getBean(AppConfig.class));
	}
}
