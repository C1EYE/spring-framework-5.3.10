package com.demo4;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Yuan
 * @description BeanC
 * @date 2022/9/5
 */
public class BeanC implements MethodReplacer {
	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("替换 BeanA test 有参"+ Arrays.toString(args));
		return null;
	}
}