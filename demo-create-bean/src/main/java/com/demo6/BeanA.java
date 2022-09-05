package com.demo6;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/5
 */
public class BeanA {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	@Autowired
	public void setMyMergedBeanDefinitionPostProcessor(MyMergedBeanDefinitionPostProcessor postProcessor){

	}
}
