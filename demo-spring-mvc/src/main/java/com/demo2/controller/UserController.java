package com.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Yuan
 * @description UserController
 * @date 2022/9/19
 */
@Controller
@RequestMapping
public class UserController {

	@GetMapping("/m1")
	public String m1(){
		System.out.println("UserController m1");
		return "m1";
	}

	@PostMapping("/m2")
	public void m2(MultipartFile file){
		System.out.println(file.getName());
		System.out.println(file.getSize());
	}
}
