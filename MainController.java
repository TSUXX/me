package com.del.test_project_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String getMain() {
		return "mainpage/main";
	}
	
	@GetMapping("/join")
	public String getJoin() {
		return "userpage/join";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "userpage/login";
	}
	
	@GetMapping("/edituser")
	public String editUser() {
		return "userpage/user";
	}
	
	@GetMapping("/main2")
	public String getMain2() {
		return "mainpage/main2";
	}
}
