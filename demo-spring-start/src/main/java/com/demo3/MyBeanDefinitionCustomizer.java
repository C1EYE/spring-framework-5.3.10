package com.demo3;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionCustomizer;

/**
 * @author Yuan
 * @description MyBeanDefinitionCustomizer
 * @date 2022/9/3
 */
public class MyBeanDefinitionCustomizer implements BeanDefinitionCustomizer {
	@Override
	public void customize(BeanDefinition bd) {
		bd.setScope("singleton");
	}
}
