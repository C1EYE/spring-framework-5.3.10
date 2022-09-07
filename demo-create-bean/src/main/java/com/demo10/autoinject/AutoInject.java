package com.demo10.autoinject;

import java.lang.annotation.*;

/**
 * @author Yuan
 * @description AutoInject
 * @date 2022/9/6
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoInject {

	boolean required() default true;
}
