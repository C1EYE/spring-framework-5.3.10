package com.demo1;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/4
 */
public class BeanA implements FactoryBean<BeanB> {
	@Override
	public BeanB getObject() throws Exception {
		return new BeanB();
	}

	@Override
	public Class<?> getObjectType() {
		return BeanB.class;
	}
}
