package com.demo6;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/3
 */
public class BeanA implements DeferredImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{BeanB.class.getName()};
	}
}
