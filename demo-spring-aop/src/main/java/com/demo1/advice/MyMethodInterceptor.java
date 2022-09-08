package com.demo1.advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Yuan
 * @description MyMethodInterceptor
 * @date 2022/9/8
 */
public class MyMethodInterceptor implements MethodInterceptor {

	@Nullable
	@Override
	public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
		System.out.println("环绕通知前");
		Object result = invocation.proceed();
		System.out.println("环绕通知后");
		return result;
	}
}
