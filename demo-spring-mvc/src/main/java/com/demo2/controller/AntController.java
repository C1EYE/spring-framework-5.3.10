package com.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Yuan
 * @description AntController
 * @date 2022/9/21
 */
@Controller
@RequestMapping
public class AntController {

	@GetMapping("/ant")
	public String ant1() {
		System.out.println("ant1");
		return "ant1";

	}

	@GetMapping("/ant?")
	public String ant2() {
		System.out.println("ant2");
		return "ant2";

	}

	@GetMapping("/ant*")
	public String ant3() {
		System.out.println("ant3");
		return "ant3";

	}

	@GetMapping("/ant{name}")
	public String ant4(@PathVariable("name") String name) {
		System.out.println("ant4");
		return "ant4";

	}

	@GetMapping("/ant**")
	public String ant5() {
		System.out.println("ant5");
		return "ant5";

	}
}
