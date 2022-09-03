package com.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * @author Yuan
 * @description ScopedProxyBeanA
 * @date 2022/9/3
 */
@Scope("singleton")
public class ScopedProxyBeanA {

	@Autowired
	private ScopedProxyBeanB scopedProxyBeanB;

	public void testScope(){
		String scopedProxyBeanB = this.scopedProxyBeanB.toString();
		System.out.println(scopedProxyBeanB);
	}
}
