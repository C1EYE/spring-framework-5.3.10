package com.demo6;

import org.springframework.context.annotation.Bean;

/**
 * @author Yuan
 * @description AppConfig
 * @date 2022/9/2
 */
public class AppConfig {

	@Bean
	public UserService userService(){
		return new UserService();
	}
}
