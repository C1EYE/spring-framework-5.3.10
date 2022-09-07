package com.demo10;

import com.demo10.autoinject.EnableAutoInject;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yuan
 * @description AppConfig
 * @date 2022/9/7
 */
@Configuration
@ComponentScan("com.demo10")
@EnableAutoInject
public class AppConfig {
}
