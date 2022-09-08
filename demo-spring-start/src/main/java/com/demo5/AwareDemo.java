package com.demo5;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;

/**
 * @author Yuan
 * @description AwareDemo
 * @date 2022/9/3
 */
public class AwareDemo implements ApplicationContextAware {

	@Override
	@Autowired
	public void setApplicationContext(@Nullable ApplicationContext applicationContext) throws BeansException {
		System.out.println("注入 ApplicationContext: " + applicationContext);
	}
}
