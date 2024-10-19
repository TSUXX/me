package com.del.test_project_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.del.test_project_1.mapper.BoardMapper;


@Controller
public class BoardController {
	@Autowired
	BoardMapper bm;
	
	@GetMapping("/post")
	public String getBoard() {
		return "postpage/post";
	}
	
	@GetMapping("/list")
	public String getBoardList(Model model) {
		model.addAttribute("list", bm.getList());
		return "postpage/boardlist";
	}
}
