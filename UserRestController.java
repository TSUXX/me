package com.del.test_project_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.del.test_project_1.dto.UserDTO;
import com.del.test_project_1.mapper.UserMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController

public class UserRestController {
	@Autowired
	UserMapper um;
	
	@PostMapping("/userAPI")
	public Boolean addUser(@RequestBody UserDTO userDTO) {
		um.addUser(userDTO);
		return true; 
	}
	
	@PostMapping("/login/user")
	public String loginUser(@RequestBody UserDTO userDTO, HttpServletRequest request) {
		UserDTO login = um.loginUser(userDTO);
		
		if(login!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userDTO.getId());
			return ("ok");
		}
		return ("fail");
	}
	
	@PutMapping("/update/user")
	public Boolean updateUser(@RequestBody UserDTO userDTO) {
		int result = um.updateUser(userDTO);
		return result > 0; 
	}
	
	@DeleteMapping("/delete/user")
	public Boolean deleteUser(@RequestBody UserDTO userDTO) {
		int result = um.deleteUser(userDTO);
		return result > 0;
	}
}
