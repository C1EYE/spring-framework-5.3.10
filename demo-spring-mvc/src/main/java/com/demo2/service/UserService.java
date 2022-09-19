package com.demo2.service;

import com.demo2.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yuan
 * @description UserService
 * @date 2022/9/19
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public void save(){
		System.out.println("UserService save");
		userDao.insert();
	}
}
