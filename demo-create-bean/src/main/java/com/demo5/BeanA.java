package com.demo5;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/5
 */
public class BeanA {

	public static BeanA ssBeanA(){
		BeanA beanA = new BeanA();
		System.out.println("FactoryMethod: "+beanA);
		return beanA;
	}
}
