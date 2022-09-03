package com.demo5;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;

/**
 * @author Yuan
 * @description AppConfig
 * @date 2022/9/3
 */
public class AppConfig {

	@Bean(autowire = Autowire.BY_TYPE)
	public AwareDemo awareDemo(){
		return new AwareDemo();
	}
}
