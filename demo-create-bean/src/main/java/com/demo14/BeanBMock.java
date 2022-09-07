package com.demo14;

/**
 * @author Yuan
 * @description BeanBMock
 * @date 2022/9/7
 */
public class BeanBMock implements InterfaceB{
	@Override
	public void getUser() {
		System.out.println("BeanBMock getUser");
	}
}
