package com.demo1.advice;

import com.demo1.bean.InterfaceB;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Yuan
 * @description MyIntroductionInterceptor
 * @date 2022/9/8
 */
public class MyIntroductionInterceptor implements IntroductionInterceptor, InterfaceB {
	@Nullable
	@Override
	public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
		if (implementsInterface(invocation.getMethod().getDeclaringClass())) {
			return invocation.getMethod().invoke(this, invocation.getArguments());
		}
		return invocation.proceed();
	}

	@Override
	public boolean implementsInterface(Class<?> intf) {
		return intf.isAssignableFrom(InterfaceB.class);
	}

	@Override
	public InterfaceB b() {
		System.out.println("MyIntroductionInterceptor::b()方法执行");
		return this;
	}
}
