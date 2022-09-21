package com.demo2.controller;

import com.demo2.model.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yuan
 * @description UserController
 * @date 2022/9/19
 */
@Controller
@RequestMapping
public class UserController {

	@InitBinder
	public void initBinder2(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@GetMapping("/m1")
	@ResponseBody
	public String m1(@RequestParam String name) {
		System.out.println("UserController m1" + name);
		return "m1";
	}

	@PostMapping("/m2")
	@ResponseBody
	public User m2(@RequestBody @Validated User user) {
		System.out.println("UserController m2" + user);
		return user;
	}

	@PutMapping("/m3/{name}")
	public String m3(@PathVariable("name") String name) {
		System.out.println("UserController m3" + name);
		return "m3";
	}

	@PostMapping("/m4")
	public String m4(MultipartFile[] files){
		System.out.println("UserController m3" + files);
		return "m4";
	}
}
