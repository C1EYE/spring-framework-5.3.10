package com.demo3;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/1
 */
public class BeanA {

	@Autowired
	private BeanB beanB;

	public void test(){
		System.out.println(beanB);
	}
}
