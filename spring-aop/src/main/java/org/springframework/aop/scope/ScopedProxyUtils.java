/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.scope;

import org.springframework.aop.framework.autoproxy.AutoProxyUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

/**
 * Utility class for creating a scoped proxy.
 *
 * <p>Used by ScopedProxyBeanDefinitionDecorator and ClassPathBeanDefinitionScanner.
 *
 * @author Mark Fisher
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @author Sam Brannen
 * @since 2.5
 */
public abstract class ScopedProxyUtils {

	private static final String TARGET_NAME_PREFIX = "scopedTarget.";

	private static final int TARGET_NAME_PREFIX_LENGTH = TARGET_NAME_PREFIX.length();


	/**
	 * Generate a scoped proxy for the supplied target bean, registering the target
	 * bean with an internal name and setting 'targetBeanName' on the scoped proxy.
	 * @param definition the original bean definition
	 * @param registry the bean definition registry
	 * @param proxyTargetClass whether to create a target class proxy
	 * @return the scoped proxy definition
	 * @see #getTargetBeanName(String)
	 * @see #getOriginalBeanName(String)
	 */
	public static BeanDefinitionHolder createScopedProxy(BeanDefinitionHolder definition,
			BeanDefinitionRegistry registry, boolean proxyTargetClass) {
		// 原始的 beanName
		String originalBeanName = definition.getBeanName();
		// 原始的 beanDefinition
		BeanDefinition targetDefinition = definition.getBeanDefinition();
		// "scopedTarget"拼接originalBeanName 组成 targetBeanName
		String targetBeanName = getTargetBeanName(originalBeanName);

		// 创建一个 ScopedProxyFactoryBean 类型的 beanDefinition
		RootBeanDefinition proxyDefinition = new RootBeanDefinition(ScopedProxyFactoryBean.class);
		// 将我们的原始目标 beanDefinition 作为代理的 beanDefinition 一个内部target属性
		proxyDefinition.setDecoratedDefinition(new BeanDefinitionHolder(targetDefinition, targetBeanName));
		proxyDefinition.setOriginatingBeanDefinition(targetDefinition);
		proxyDefinition.setSource(definition.getSource());
		proxyDefinition.setRole(targetDefinition.getRole());

		proxyDefinition.getPropertyValues().add("targetBeanName", targetBeanName);
		// 判断是否使用cglib来生成的代理
		if (proxyTargetClass) {
			targetDefinition.setAttribute(AutoProxyUtils.PRESERVE_TARGET_CLASS_ATTRIBUTE, Boolean.TRUE);
			// ScopedProxyFactoryBean 的 proxyTargetClass 默认为 true，所以我们这里不需要显式设置。
		}
		else {
			proxyDefinition.getPropertyValues().add("proxyTargetClass", Boolean.FALSE);
		}

		// 复制原始 beanDefinition的 自动装配，Primary，Qualifiers属性设置
		proxyDefinition.setAutowireCandidate(targetDefinition.isAutowireCandidate());
		proxyDefinition.setPrimary(targetDefinition.isPrimary());
		if (targetDefinition instanceof AbstractBeanDefinition) {
			proxyDefinition.copyQualifiersFrom((AbstractBeanDefinition) targetDefinition);
		}

		// 将原始的 beanDefinition 设置不作为自动装配的候选者
		targetDefinition.setAutowireCandidate(false);
		// 设置为原始的 beanDefinition 不作为主要的候选者
		targetDefinition.setPrimary(false);
		// 这两个设置，一般来说在进行自动装配的时候，我们就不会找到这个类了，而是使用代理类

		// 将原始的 beanDefinition 注册到容器
		registry.registerBeanDefinition(targetBeanName, targetDefinition);

		// 这里将我们前面的 ScopedProxyFactoryBean 类型的 beanDefinition，返回并且替代了原始的 beanDefinition
		return new BeanDefinitionHolder(proxyDefinition, originalBeanName, definition.getAliases());
	}

	/**
	 * Generate the bean name that is used within the scoped proxy to reference the target bean.
	 * @param originalBeanName the original name of bean
	 * @return the generated bean to be used to reference the target bean
	 * @see #getOriginalBeanName(String)
	 */
	public static String getTargetBeanName(String originalBeanName) {
		return TARGET_NAME_PREFIX + originalBeanName;
	}

	/**
	 * Get the original bean name for the provided {@linkplain #getTargetBeanName
	 * target bean name}.
	 * @param targetBeanName the target bean name for the scoped proxy
	 * @return the original bean name
	 * @throws IllegalArgumentException if the supplied bean name does not refer
	 * to the target of a scoped proxy
	 * @since 5.1.10
	 * @see #getTargetBeanName(String)
	 * @see #isScopedTarget(String)
	 */
	public static String getOriginalBeanName(@Nullable String targetBeanName) {
		Assert.isTrue(isScopedTarget(targetBeanName), () -> "bean name '" +
				targetBeanName + "' does not refer to the target of a scoped proxy");
		return targetBeanName.substring(TARGET_NAME_PREFIX_LENGTH);
	}

	/**
	 * Determine if the {@code beanName} is the name of a bean that references
	 * the target bean within a scoped proxy.
	 * @since 4.1.4
	 */
	public static boolean isScopedTarget(@Nullable String beanName) {
		return (beanName != null && beanName.startsWith(TARGET_NAME_PREFIX));
	}

}
