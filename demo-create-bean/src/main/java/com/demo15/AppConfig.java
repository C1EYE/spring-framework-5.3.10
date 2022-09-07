package com.demo15;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Yuan
 * @description AppConfig
 * @date 2022/9/7
 */
@Configuration
@PropertySource(value = "a.properties",encoding = "UTF-8")
@PropertySource(value = "b.properties",encoding = "UTF-8")
public class AppConfig {
}
