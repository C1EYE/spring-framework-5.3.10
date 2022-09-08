package com.demo1.bean;

import org.springframework.stereotype.Component;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/6
 */
@Component
public class BeanA implements InterfaceA {

	@Override
	public InterfaceA a() {
		System.out.println("BeanA::a()方法执行");
		return this;
	}
}
