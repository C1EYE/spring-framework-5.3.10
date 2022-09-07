package com.demo12;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/6
 */
public class BeanA {

	@Autowired
	public void test(BeanB beanB1){
		// 根据参数类型找 Bean,找到多个,参数名字匹配
		// 名字匹配不上抛异常
		System.out.println(beanB1);
	}

	@PostConstruct
	public void abc(){
		System.out.println("初始化方法");
	}
}
