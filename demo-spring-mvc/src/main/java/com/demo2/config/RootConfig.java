package com.demo2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yuan
 * @description RootConfig
 * @date 2022/9/19
 */
@Configuration
@ComponentScans({@ComponentScan("com.demo2.service"), @ComponentScan("com.demo2.dao")})
public class RootConfig {
}
