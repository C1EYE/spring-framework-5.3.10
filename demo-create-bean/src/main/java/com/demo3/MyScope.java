package com.demo3;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Objects;

/**
 * @author Yuan
 * @description MyScope
 * @date 2022/9/4
 */
public class MyScope implements Scope {
	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		Object obj = ThreadContext.get(name);
		if (Objects.isNull(obj)) {
			obj = objectFactory.getObject();
			ThreadContext.set(name, obj);

		}
		return obj;
	}

	@Override
	public Object remove(String name) {
		Object obj = ThreadContext.get(name);
		ThreadContext.remove();
		return obj;
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {

	}

	@Override
	public Object resolveContextualObject(String key) {
		return null;
	}

	@Override
	public String getConversationId() {
		return null;
	}
}
