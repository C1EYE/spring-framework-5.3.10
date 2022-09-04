package com.demo3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Yuan
 * @description ThreadContext
 * @date 2022/9/4
 */
public class ThreadContext {
	private final static ThreadLocal<Map<String, Object>> context = new ThreadLocal<>();

	public static Object get(String key) {
		Map<String, Object> map = context.get();
		if (Objects.isNull(map)) {
			map = new HashMap<>();
			context.set(map);
			return null;
		}
		return context.get().get(key);
	}

	public static void set(String key, Object value) {
		Map<String, Object> map = context.get();
		if (Objects.isNull(map)) {
			map = new HashMap<>();
		}
		map.put(key, value);

	}

	public static void remove() {
		context.remove();
	}
}
