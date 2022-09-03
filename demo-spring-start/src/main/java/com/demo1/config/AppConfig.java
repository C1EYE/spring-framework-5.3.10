package com.demo1.config;

import com.demo1.annotation.Demo;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yuan
 * @description AppConfig
 * @date 2022/9/1
 */
@Demo
@Configuration
@Conditional({MyCondition.class})
public class AppConfig {
}
