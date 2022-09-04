package com.demo5;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/4
 */
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BeanA {

	private String name;

	public void setName(String name) {
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
}
