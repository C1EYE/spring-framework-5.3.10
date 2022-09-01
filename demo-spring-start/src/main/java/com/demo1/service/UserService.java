package com.demo1.service;

import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.inject.Named;

/**
 * @author Yuan
 * @description UserService
 * @date 2022/9/1
 */
@Component
//@Named
//@ManagedBean
public class UserService {

	public void test(){
		System.out.println("userService");
	}
}
