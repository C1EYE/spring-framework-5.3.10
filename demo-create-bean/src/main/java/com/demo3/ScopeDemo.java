package com.demo3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Yuan
 * @description DependsOnDemo
 * @date 2022/9/4
 */
public class ScopeDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(RegisterScopeBeanFactoryPostProcessor.class);
		context.register(BeanA.class);
		context.register(BeanB.class);
		context.refresh();
		ThreadPoolExecutor threadPoolExecutor =
				new ThreadPoolExecutor(3, 5, 100L,
						TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
		Runnable runnable = () -> {
			BeanA bean = context.getBean(BeanA.class);
			for (int i = 0; i < 10; i++) {
				bean.test();
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};
		threadPoolExecutor.execute(runnable);
		threadPoolExecutor.execute(runnable);
	}
}
