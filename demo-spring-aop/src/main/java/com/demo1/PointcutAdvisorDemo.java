package com.demo1;

import com.demo1.advice.*;
import com.demo1.bean.BeanA;
import org.aopalliance.aop.Advice;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @author Yuan
 * @description Demo
 * @date 2022/9/6
 */
public class PointcutAdvisorDemo {
	public static void main(String[] args) {
		BeanA beanA = new BeanA();
		ProxyFactory factory = new ProxyFactory(beanA);
		factory.addAdvisor(new PointcutAdvisor() {
			@Override
			public Pointcut getPointcut() {
				return new Pointcut() {
					@Override
					public ClassFilter getClassFilter() {
						return clazz -> clazz.isAssignableFrom(BeanA.class);
					}

					@Override
					public MethodMatcher getMethodMatcher() {
						return new MethodMatcher() {
							@Override
							public boolean matches(Method method, Class<?> targetClass) {
								return "a".equals(method.getName());
							}

							@Override
							public boolean isRuntime() {
								return false;
							}

							@Override
							public boolean matches(Method method, Class<?> targetClass, Object... args) {
								return false;
							}
						};
					}
				};
			}

			@Override
			public Advice getAdvice() {
				return new MyMethodBeforeAdvice();
			}

			@Override
			public boolean isPerInstance() {
				return false;
			}
		});
		BeanA proxy = (BeanA) factory.getProxy();
		proxy.a();
	}
}
