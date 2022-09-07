package com.demo14;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.lang.Nullable;

/**
 * @author Yuan
 * @description MockBeanPostProcessor
 * @date 2022/9/7
 */
public class MockBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(@Nullable Class<?> beanClass, @Nullable String beanName) throws BeansException {
		if (AnnotatedElementUtils.hasAnnotation(beanClass, Mock.class)) {
			Mock mock = AnnotatedElementUtils.getMergedAnnotation(beanClass, Mock.class);
			Class<?> clazz = mock.value();
			try {
				return clazz.getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}
}
