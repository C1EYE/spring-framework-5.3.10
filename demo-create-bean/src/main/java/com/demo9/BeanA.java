package com.demo9;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/6
 */
public class BeanA {

	private BeanA(BeanB beanB){
		System.out.println("构造"+beanB);
	}
}
