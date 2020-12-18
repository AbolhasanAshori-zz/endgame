package com.endgame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class NewsController {

	@GetMapping
	public String showNews(Model theModel){
		
		theModel.addAttribute("title", "blog");
		
		return "blog";
	}
}
