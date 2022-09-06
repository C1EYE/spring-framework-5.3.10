package com.demo1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Yuan
 * @description Advisor
 * @date 2022/9/6
 */
@Aspect
@Component
public class Advisor {
	@Before("execution(public void com.demo1.BeanA.m1())")
	public void before(){
		System.out.println("before");
	}
}
