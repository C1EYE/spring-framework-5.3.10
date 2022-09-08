package com.demo1;

import org.springframework.aop.RawTargetAccess;
import org.springframework.stereotype.Component;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/6
 */
@Component
public class BeanA implements InterfaceA, RawTargetAccess {

	@Override
	public InterfaceA m1() {
		System.out.println("m1方法执行");
		return this;
	}
}
