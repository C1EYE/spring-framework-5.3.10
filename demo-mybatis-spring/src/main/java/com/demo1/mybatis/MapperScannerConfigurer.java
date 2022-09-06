package com.demo1.mybatis;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author Yuan
 * @description MapperScannerConfigurer
 * @date 2022/9/6
 */
public class MapperScannerConfigurer implements BeanDefinitionRegistryPostProcessor {

	private String basePackage;


	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		ClassPathMapperScanner scanner = new ClassPathMapperScanner(registry);
		scanner.scan(basePackage);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}


	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
}
