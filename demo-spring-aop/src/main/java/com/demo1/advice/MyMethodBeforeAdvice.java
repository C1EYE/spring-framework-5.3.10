package com.demo1.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author Yuan
 * @description MyMethodBeforeAdvice
 * @date 2022/9/8
 */
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("方法执行前");
	}
}
