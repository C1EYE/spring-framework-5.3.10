package com.demo6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

/**
 * @author Yuan
 * @description BeanB
 * @date 2022/9/4
 */
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BeanB {

	@Autowired
	private BeanA beanA;
}
