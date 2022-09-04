package com.demo6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yuan
 * @description ConfigA
 * @date 2022/9/3
 */
@Configuration
public class ConfigA{
	@Bean
	public BeanB beanB(){
		return new BeanB();
	}
}
