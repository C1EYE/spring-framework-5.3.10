package com.demo4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Yuan
 * @description AppConfig
 * @date 2022/9/5
 */
@ImportResource({"PrepareMethodOverrides.xml"})
public class AppConfig {

	@Bean
	public BeanA beanA(){
		return new BeanA();
	}
}
