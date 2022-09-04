package com.demo4;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @author Yuan
 * @description MyInstantiationAwareBeanPostProcessor
 * @date 2022/9/4
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if ("beanA".equals(beanName)) {
			// 这里如果你返回了一个对象，那么就会直接使用这个对象作为 Bean，不会帮你创建了
			// 但是还有可能被 BeanPostProcessor#postProcessBeforeInitialization 覆盖
			System.out.println("MyInstantiationAwareBeanPostProcessor=> "+1);
			return new BeanB();
		}
		return null;
	}
}
