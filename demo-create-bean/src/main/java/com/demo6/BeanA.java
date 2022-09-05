package com.demo6;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/5
 */
@Scope(scopeName = BeanDefinition.SCOPE_PROTOTYPE)
public class BeanA {

	private BeanB beanB;

	public BeanA(BeanB beanB) {
		this.beanB = beanB;
	}
}
