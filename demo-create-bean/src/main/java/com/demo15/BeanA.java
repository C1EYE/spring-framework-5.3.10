package com.demo15;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/7
 */
public class BeanA implements InitializingBean {

	/**
	 * 查找优先级顺序
	 * 先去 PropertiesPropertySource {name='systemProperties'} 找
	 * 再去 SystemEnvironmentPropertySource {name='systemEnvironment'} 找
	 * 最后用户自定义的 ResourcePropertySource {name='class path resource [xxx.properties]'}
	 */
	@Value("${sun.desktop}")
	private String name;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(name);
	}
}
