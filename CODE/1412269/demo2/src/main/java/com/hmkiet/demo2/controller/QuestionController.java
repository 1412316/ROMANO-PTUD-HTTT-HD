package com.hmkiet.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hmkiet.demo2.service.QuestionService;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/a")
	public String userForm(Model model) {
		model.addAttribute("questions", questionService.list());
		return "question";
	   }
}
