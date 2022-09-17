package com.demo1.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yuan
 * @description IUserService
 * @date 2022/9/17
 */
@Transactional(rollbackFor = Exception.class)
public interface IUserService {

	void m1();
}
