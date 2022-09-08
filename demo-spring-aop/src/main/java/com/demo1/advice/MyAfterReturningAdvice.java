package com.demo1.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author Yuan
 * @description MyAfterReturningAdvice
 * @date 2022/9/8
 */
public class MyAfterReturningAdvice implements AfterReturningAdvice {
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("方法返回后" + returnValue);
	}
}
