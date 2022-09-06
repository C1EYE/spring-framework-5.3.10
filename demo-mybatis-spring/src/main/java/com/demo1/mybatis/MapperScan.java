package com.demo1.mybatis;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Yuan
 * @description MapperScan
 * @date 2022/9/6
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({MapperScannerRegistrar.class})
public @interface MapperScan {
	String value();
}
