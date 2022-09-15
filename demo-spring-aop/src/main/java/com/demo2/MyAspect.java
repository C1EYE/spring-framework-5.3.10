package com.demo2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Yuan
 * @description MyAdvisor
 * @date 2022/9/15
 */
@Aspect
@Component
public class MyAspect {

	@Pointcut("execution(* com.demo2.BeanA.*(..))")
	public void demo2(){

	}

	@Before("demo2()")
	public void myBefore(){
		System.out.println("before");
	}
}
