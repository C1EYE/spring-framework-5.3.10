package com.demo1;

import java.util.ServiceLoader;

/**
 * @author Yuan
 * @description SPIDemo
 * @date 2022/9/19
 */
public class SPIDemo {
	public static void main(String[] args) {
		ServiceLoader<UserService> load = ServiceLoader.load(UserService.class);
		for (UserService userService : load) {
			userService.delete();
		}
	}
}
