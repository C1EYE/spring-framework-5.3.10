package com.demo10.autoinject;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Yuan
 * @description AutoInjectRegistrar
 * @date 2022/9/7
 */
public class AutoInjectRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
		RootBeanDefinition beanDefinition = new RootBeanDefinition(AutoInjectBeanPostProcessors.class);
		registry.registerBeanDefinition("autoInjectBeanPostProcessors",beanDefinition);
	}
}
