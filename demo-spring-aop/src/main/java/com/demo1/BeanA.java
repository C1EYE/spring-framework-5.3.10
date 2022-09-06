package com.demo1;

import org.springframework.stereotype.Component;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/6
 */
@Component
public class BeanA implements InterfaceA{
	@Override
	public void m1() {
		System.out.println("m1");
	}
}
