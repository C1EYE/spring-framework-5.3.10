package com.demo1.config;

import com.demo1.annotation.Demo;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * @author Yuan
 * @description MyCondition
 * @date 2022/9/1
 */
public class MyCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 如果该配置类上有 @Demo 注解那么就跳过，不解析注册到容器
		if (metadata.isAnnotated(Demo.class.getName())){
			return false;
		}
		return true;
	}
}
