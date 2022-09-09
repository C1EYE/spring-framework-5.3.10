package com.demo1;

import com.demo1.advice.MyIntroductionInterceptor;
import com.demo1.bean.BeanA;
import com.demo1.bean.InterfaceB;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author Yuan
 * @description IntroductionAdvisor
 * @date 2022/9/8
 */
public class IntroductionAdvisor {
	public static void main(String[] args) throws InterruptedException {
		BeanA beanA = new BeanA();
		ProxyFactory factory = new ProxyFactory(beanA);
		factory.addAdvice(new MyIntroductionInterceptor());
		InterfaceB proxy = (InterfaceB) factory.getProxy();
		proxy.b();
		Thread.sleep(10000000000000L);
	}
}
