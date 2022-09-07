package com.demo10.autoinject;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Yuan
 * @description EnableAutoInject
 * @date 2022/9/7
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AutoInjectRegistrar.class)
public @interface EnableAutoInject {
}
