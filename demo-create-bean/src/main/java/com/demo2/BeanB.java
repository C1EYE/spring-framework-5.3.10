package com.demo2;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Yuan
 * @description BeanB
 * @date 2022/9/4
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BeanB {

	@Component("beanC")
	public class BeanC{

	}
}
