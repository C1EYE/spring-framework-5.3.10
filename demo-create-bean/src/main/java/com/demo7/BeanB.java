package com.demo7;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Yuan
 * @description BeanB
 * @date 2022/9/6
 */
public class BeanB {
	@Autowired
	private BeanA beanA;
}
