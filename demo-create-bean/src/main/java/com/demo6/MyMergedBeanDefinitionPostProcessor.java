package com.demo6;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author Yuan
 * @description BeanB
 * @date 2022/9/5
 */
public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {

	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
		if ("beanA".equals(beanName)){
			beanDefinition.getPropertyValues().add("name","李四");
		}
	}
}
