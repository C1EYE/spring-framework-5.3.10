package com.demo2;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author Yuan
 * @description MyBeanDefinitionCustomizer
 * @date 2022/9/1
 */
public class MyBeanDefinitionCustomizer implements BeanDefinitionCustomizer {
	@Override
	public void customize(BeanDefinition bd) {
		System.out.println("原始："+bd.getScope());
		bd.setScope(ConfigurableBeanFactory.SCOPE_PROTOTYPE);
		System.out.println("修改后："+bd.getScope());
	}
}
