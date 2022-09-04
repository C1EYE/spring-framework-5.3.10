package com.demo5;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Yuan
 * @description MyBeanPostProcessor
 * @date 2022/9/4
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("beanA".equals(beanName)) {
			// 这里如果你返回了一个对象，那么就会直接使用这个对象作为 Bean，不会帮你创建了
			// 如果 bean 不等于 null，那说明是来自MyInstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation创建的bean
			System.out.println("MyBeanPostProcessor=> "+2);
			return new BeanC();
		}
		return null;
	}
}
