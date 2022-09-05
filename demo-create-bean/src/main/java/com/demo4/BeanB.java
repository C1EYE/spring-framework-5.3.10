package com.demo4;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author Yuan
 * @description BeanB
 * @date 2022/9/5
 */
public class BeanB implements MethodReplacer {
	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("BeanB reimplement");
		return null;
	}
}
