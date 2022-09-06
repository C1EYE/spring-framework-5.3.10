package com.demo1.mybatis;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Yuan
 * @description MapperScannerRegistrar
 * @date 2022/9/6
 */
public class MapperScannerRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// 获取 MapperScan 注解
		AnnotationAttributes mapperScanAttrs = AnnotationAttributes
				.fromMap(importingClassMetadata.getAnnotationAttributes(MapperScan.class.getName()));
		assert mapperScanAttrs != null;
		// 生成 BeanName
		String beanName = generateBaseBeanName(importingClassMetadata, 0);
		// 注册 MapperScannerConfigurer BeanDefinition
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MapperScannerConfigurer.class);
		// 将扫描包名添加到属性里
		builder.addPropertyValue("basePackage", mapperScanAttrs.getString("value"));
		registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
	}

	private static String generateBaseBeanName(AnnotationMetadata importingClassMetadata, int index) {
		return importingClassMetadata.getClassName() + "#" + MapperScannerRegistrar.class.getSimpleName() + "#" + index;
	}
}
