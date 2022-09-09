package com.demo1;

import com.demo1.advice.MyAfterReturningAdvice;
import com.demo1.advice.MyMethodBeforeAdvice;
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
		factory.addAdvice(new MyMethodBeforeAdvice());
		factory.addAdvice(new MyAfterReturningAdvice());
		factory.setProxyTargetClass(true);
		InterfaceA proxy = (InterfaceA) factory.getProxy();
		proxy.a();
	}
}
