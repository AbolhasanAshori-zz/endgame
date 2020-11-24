package com.endgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.endgame.service.GameService;

@Controller
public class HomeController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping("/")
	public String redirectToHome() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String showHome(Model theModel) {
		
		return "home";
	}
}
