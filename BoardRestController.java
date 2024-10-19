package com.del.test_project_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.del.test_project_1.dto.BoardDTO;
import com.del.test_project_1.mapper.BoardMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class BoardRestController {
	@Autowired
	BoardMapper bm;
	
	@PostMapping("post/data")
	public Boolean addPost(@RequestBody BoardDTO boardDTO, HttpServletRequest request) { 
		HttpSession session = request.getSession(false);
		
		if(session!=null) {
			String userId = (String) session.getAttribute("userId");
			
			if(userId != null) {
				boardDTO.setId(userId);
				bm.postBoard(boardDTO);
				return true;
			}
		}
		return false;
	}
}
