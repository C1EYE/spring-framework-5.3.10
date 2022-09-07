package com.demo10.autoinject;

import org.springframework.beans.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.lang.Nullable;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Yuan
 * @description AutoInjectBeanPostProcessors
 * @date 2022/9/6
 */
public class AutoInjectBeanPostProcessors implements BeanFactoryAware,
		MergedBeanDefinitionPostProcessor, SmartInstantiationAwareBeanPostProcessor {

	private final Map<String, InjectionMetadata> injectionMetadataCache = new ConcurrentHashMap<>(256);
	private ConfigurableListableBeanFactory beanFactory;

	/**
	 * 寻找注入点解析并保存
	 */
	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
		InjectionMetadata metadata = findAutowiringMetadata(beanName, beanType, null);
		metadata.checkConfigMembers(beanDefinition);
	}

	/**
	 * 解析注入点,进行属性依赖注入
	 */
	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) {
		InjectionMetadata metadata = findAutowiringMetadata(beanName, bean.getClass(), pvs);
		try {
			metadata.inject(bean, beanName, pvs);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
		return pvs;
	}

	private InjectionMetadata findAutowiringMetadata(String beanName, Class<?> clazz, @Nullable PropertyValues pvs) {
		//  生成缓存 Key
		String cacheKey = (StringUtils.hasLength(beanName) ? beanName : clazz.getName());
		// 从缓存中获取
		InjectionMetadata metadata = this.injectionMetadataCache.get(cacheKey);
		// 判断是否需要重新解析,缓存为空或者本次解析的 class 与 metadata 缓存上次解析的 class不一致
		if (InjectionMetadata.needsRefresh(metadata, clazz)) {
			// 双检锁机制
			synchronized (this.injectionMetadataCache) {
				// 再次获取缓存是否存在
				metadata = this.injectionMetadataCache.get(cacheKey);
				if (InjectionMetadata.needsRefresh(metadata, clazz)) {
					if (metadata != null) {
						metadata.clear(pvs);
					}
					// 解析class 存在注入点
					metadata = buildAutowiringMetadata(clazz);
					// 将解析得到的数据放入缓存
					this.injectionMetadataCache.put(cacheKey, metadata);
				}
			}
		}

		return metadata;
	}

	private InjectionMetadata buildAutowiringMetadata(Class<?> clazz) {
		// 判断类中是否有 AutoInject 注解
		if (!AnnotationUtils.isCandidateClass(clazz, AutoInject.class)) {
			return InjectionMetadata.EMPTY;
		}
		List<InjectionMetadata.InjectedElement> currElements = new ArrayList<>();
		// 检查所有的属性
		ReflectionUtils.doWithLocalFields(clazz, field -> {
			MergedAnnotation<?> ann = findAutowiredAnnotation(field);
			if (ann != null) {
				boolean required = ann.getBoolean("required");
				currElements.add(new AutoInjectFieldElement(field,required));
			}
		});

		// 检查所有的方法
		ReflectionUtils.doWithLocalMethods(clazz, method -> {
			MergedAnnotation<?> ann = findAutowiredAnnotation(method);
			if (ann != null) {
				PropertyDescriptor pd = BeanUtils.findPropertyForMethod(method, clazz);
				boolean required = ann.getBoolean("required");
				currElements.add(new AutoInjectMethodElement(method, pd,required));
			}
		});
		return InjectionMetadata.forElements(currElements, clazz);
	}

	private MergedAnnotation<?> findAutowiredAnnotation(AccessibleObject ao) {
		MergedAnnotations annotations = MergedAnnotations.from(ao);
		MergedAnnotation<?> annotation = annotations.get(AutoInject.class);
		if (annotation.isPresent()) {
			return annotation;
		}
		return null;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = (ConfigurableListableBeanFactory)beanFactory;
	}

	private class AutoInjectFieldElement extends InjectionMetadata.InjectedElement {
		private final boolean required;
		protected AutoInjectFieldElement(Member member,boolean required) {
			super(member, null);
			this.required = required;
		}

		@Override
		protected void inject(Object bean, String beanName, PropertyValues pvs) throws Throwable {
			Field field = (Field) this.member;
			Object value;
			DependencyDescriptor desc = new DependencyDescriptor(field,this.required);
			desc.setContainingClass(bean.getClass());
			Set<String> autowiredBeanNames = new LinkedHashSet<>(1);
			TypeConverter typeConverter =  beanFactory.getTypeConverter();
			value = beanFactory.resolveDependency(desc, beanName, autowiredBeanNames, typeConverter);
			ReflectionUtils.makeAccessible(field);
			field.set(bean, value);
		}
	}

	private class AutoInjectMethodElement extends InjectionMetadata.InjectedElement{
		private final boolean required;
		public AutoInjectMethodElement(Member member, PropertyDescriptor pd,boolean required) {
			super(member, pd);
			this.required = required;
		}

		@Override
		protected void inject(Object bean, String beanName, PropertyValues pvs) throws Throwable {
			Method method = (Method) this.member;
			int argumentCount = method.getParameterCount();
			Object[] arguments = new Object[argumentCount];
			Set<String> autowiredBeans = new LinkedHashSet<>(argumentCount);
			TypeConverter typeConverter = beanFactory.getTypeConverter();
			for (int i = 0; i < arguments.length; i++) {
				MethodParameter methodParam = new MethodParameter(method, i);
				DependencyDescriptor currDesc = new DependencyDescriptor(methodParam, this.required);
				currDesc.setContainingClass(bean.getClass());
				Object arg = beanFactory.resolveDependency(currDesc, beanName, autowiredBeans, typeConverter);
				arguments[i] = arg;
			}
			ReflectionUtils.makeAccessible(method);
			method.invoke(bean, arguments);
		}
	}

}
