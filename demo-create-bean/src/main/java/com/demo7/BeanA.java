package com.demo7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/6
 */
public class BeanA {
	@Autowired
	private BeanB beanB;

	@Async
	public void test(){
		System.out.println("异步方法");
	}
}
