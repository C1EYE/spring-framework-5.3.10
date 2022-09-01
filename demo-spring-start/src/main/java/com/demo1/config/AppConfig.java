package com.demo1.config;

import com.demo1.annotation.Demo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;

/**
 * @author Yuan
 * @description AppConfig
 * @date 2022/9/1
 */
@ComponentScan("com.demo1")
@Demo
@Conditional({MyCondition.class})
public class AppConfig {
}
