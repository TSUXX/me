package com.del.test_project_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class SignController {
	
	@GetMapping("logout")
	public String logoutUser(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();	
		}
		return "redirect:/";
	}
	
}
