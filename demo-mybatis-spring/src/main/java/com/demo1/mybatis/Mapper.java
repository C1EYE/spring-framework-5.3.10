package com.demo1.mybatis;

import java.lang.annotation.*;

/**
 * @author Yuan
 * @description Mapper
 * @date 2022/9/6
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Mapper {
}
