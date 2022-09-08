package com.demo1;

import com.demo1.advice.MyIntroductionInterceptor;
import com.demo1.bean.BeanA;
import com.demo1.bean.InterfaceB;
import org.springframework.aop.Advisor;
import org.springframework.aop.DynamicIntroductionAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * @author Yuan
 * @description IntroductionAdvisor
 * @date 2022/9/8
 */
public class IntroductionAdvisor {
	public static void main(String[] args) {
		BeanA beanA = new BeanA();
		ProxyFactory factory = new ProxyFactory(beanA);
		DynamicIntroductionAdvice advice = new MyIntroductionInterceptor();
		Advisor advisor = new DefaultIntroductionAdvisor(advice, InterfaceB.class);
		factory.addAdvisor(advisor);
		factory.setProxyTargetClass(false);
		InterfaceB proxy = (InterfaceB) factory.getProxy();
		proxy.b();
	}
}
