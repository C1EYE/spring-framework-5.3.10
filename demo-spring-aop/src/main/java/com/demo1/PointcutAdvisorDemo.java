package com.demo1;

import com.demo1.advice.MyAfterReturningAdvice;
import com.demo1.advice.MyMethodBeforeAdvice;
import com.demo1.advice.MyMethodInterceptor;
import com.demo1.advice.MyThrowsAdvice;
import com.demo1.bean.BeanA;
import com.demo1.bean.InterfaceA;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author Yuan
 * @description Demo
 * @date 2022/9/6
 */
public class PointcutAdvisorDemo {
	public static void main(String[] args) {
		BeanA beanA = new BeanA();
		ProxyFactory factory = new ProxyFactory(beanA);
		factory.addAdvice(new MyAfterReturningAdvice());
		factory.addAdvice(new MyMethodBeforeAdvice());
		factory.addAdvice(new MyMethodInterceptor());
		factory.addAdvice(new MyThrowsAdvice());
		factory.setProxyTargetClass(true);
		InterfaceA proxy = (InterfaceA) factory.getProxy();
		proxy.a();
	}
}
