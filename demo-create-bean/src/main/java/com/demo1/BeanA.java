package com.demo1;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/4
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
