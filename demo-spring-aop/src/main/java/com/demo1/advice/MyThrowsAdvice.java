package com.demo1.advice;

import org.springframework.aop.ThrowsAdvice;

/**
 * @author Yuan
 * @description MyThrowsAdvice
 * @date 2022/9/8
 */
public class MyThrowsAdvice implements ThrowsAdvice {

	public void afterThrowing(NullPointerException ex) {
		System.out.println("抛异常" + ex);
	}

	public void afterThrowing(IllegalArgumentException ex) {
		System.out.println("抛异常" + ex);
	}
}
