package com.demo7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author Yuan
 * @description 容器刷新完成事件，会将当前 context 传入进来
 * @date 2022/9/6
 */
public class MyContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ApplicationContext applicationContext = event.getApplicationContext();
		System.out.println(applicationContext);
	}
}
