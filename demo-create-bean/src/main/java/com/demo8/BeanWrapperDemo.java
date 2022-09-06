package com.demo8;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

/**
 * @author Yuan
 * @description BeanWrapper 相当于是Spring中的一个包装类，对Bean 进行包装，
 * 具有（单独或批量）获取和设置属性值，获取属性描述符以及查询属性的可读性/可写性的能力。
 * @date 2022/9/6
 */
public class BeanWrapperDemo {
	public static void main(String[] args) {
		BeanWrapper beanWrapper = new BeanWrapperImpl(new Person());
		PropertyValue property1 = new PropertyValue("name","李四");
		PropertyValue property2 = new PropertyValue("age","22");
		beanWrapper.setPropertyValue(property1);
		beanWrapper.setPropertyValue(property2);
		Person instance = (Person)beanWrapper.getWrappedInstance();
		System.out.println(instance);
	}
}
