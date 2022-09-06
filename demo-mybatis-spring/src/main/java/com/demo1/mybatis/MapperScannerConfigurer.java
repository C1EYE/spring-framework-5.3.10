package com.demo1.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Yuan
 * @description MapperScannerConfigurer
 * @date 2022/9/6
 */
public class MapperScannerConfigurer implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware, BeanNameAware {

	private String basePackage;
	private ConfigurableApplicationContext context;
	private String beanName;


	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		SqlSessionFactory sqlSessionFactory = context.getBean(SqlSessionFactory.class);
		ClassPathMapperScanner scanner = new ClassPathMapperScanner(registry);
		scanner.setSqlSessionFactory(sqlSessionFactory);
		scanner.scan(basePackage);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = (ConfigurableApplicationContext) applicationContext;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
}
