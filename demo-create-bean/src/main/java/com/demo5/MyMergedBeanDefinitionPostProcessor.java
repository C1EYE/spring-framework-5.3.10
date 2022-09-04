package com.demo5;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author Yuan
 * @description MyMergedBeanDefinitionPostProcessor
 * @date 2022/9/4
 */
public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {
	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
		// 在创建 bean 完实例之后，可以通过此扩展，修改 beanDefinition
		if ("beanA".equals(beanName)){
			beanDefinition.getPropertyValues().add("name","张三");
		}

	}
}
