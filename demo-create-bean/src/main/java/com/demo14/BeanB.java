package com.demo14;

/**
 * @author Yuan
 * @description BeanB
 * @date 2022/9/7
 */
@Mock(BeanBMock.class)
public class BeanB implements InterfaceB{
	@Override
	public void getUser() {
		System.out.println("BeanB getUser");
	}
}
