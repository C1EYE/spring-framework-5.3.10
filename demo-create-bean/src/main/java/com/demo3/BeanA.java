package com.demo3;

import org.springframework.context.annotation.DependsOn;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/4
 */
@DependsOn({"beanB"})
public class BeanA {
}
