package com.demo3;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/4
 */
public class BeanA {
	@Autowired
	private BeanB beanB;

	public void test() {
		String name = Thread.currentThread().getName();
		System.out.println(name + ": " + beanB);
	}
}
