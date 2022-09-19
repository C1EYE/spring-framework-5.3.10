package com.demo2.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletRegistration;

/**
 * @author Yuan
 * @description MyWebAppInitializer
 * @date 2022/9/19
 */
public class MyWebAppInitializer  {

//	/**
//	 * 父容器配置类
//	 */
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		return new Class[]{RootConfig.class};
//	}
//
//	/**
//	 * 子容器配置类
//	 */
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		return new Class[]{WebConfig.class};
//	}
//
//	/**
//	 * DispatchServlet 路径映射
//	 */
//	@Override
//	protected String[] getServletMappings() {
//		return new String[]{"/"};
//	}
//
//	/**
//	 * 父容器刷新前的回调
//	 */
//	@Override
//	protected ApplicationContextInitializer<?>[] getRootApplicationContextInitializers() {
//		return new ApplicationContextInitializer[]{applicationContext -> {
//			System.out.println("收到 RootApplicationContextInitializers");
//		}};
//	}
//
//	/**
//	 * 子容器初始化前的回调
//	 */
//	@Override
//	protected ApplicationContextInitializer<?>[] getServletApplicationContextInitializers() {
//		return new ApplicationContextInitializer[]{applicationContext -> {
//			System.out.println("收到 ServletApplicationContextInitializers");
//		}};
//	}
//
//	/**
//	 * 注册 DispatcherServlet 的最后修改回调
//	 */
//	@Override
//	protected void customizeRegistration(@NonNull ServletRegistration.Dynamic registration) {
//		System.out.println(registration);
//	}
}
