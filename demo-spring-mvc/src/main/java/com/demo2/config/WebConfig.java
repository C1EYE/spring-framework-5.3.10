package com.demo2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Yuan
 * @description WebConfig
 * @date 2022/9/19
 */
@Configuration
@ComponentScan("com.demo2.controller")
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new
				CommonsMultipartResolver();
		multipartResolver.setSupportedMethods("GET","POST");
		return multipartResolver;
	}

}
