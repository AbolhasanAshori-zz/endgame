package com.endgame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class ReviewController {

	@GetMapping
	public String showReview(Model theModel){

		theModel.addAttribute("title", "Review");

		return "review";
	}
}
