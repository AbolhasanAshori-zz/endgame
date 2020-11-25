package com.endgame.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.endgame.entity.Game;
import com.endgame.entity.Rating;
import com.endgame.entity.Testimonial;
import com.endgame.service.GameService;
import com.endgame.service.RatingService;
import com.endgame.service.TestimonialService;

@Controller
@RequestMapping("/games")
public class GamesController {
	
	private GameService gameService;
	private TestimonialService testimonialService;
	private RatingService ratingService;
	
	public GamesController() {
		
	}
	
	@Autowired
	public GamesController(GameService gameService, TestimonialService testimonialService,
			RatingService ratingService) {
		this.gameService = gameService;
		this.testimonialService = testimonialService;
		this.ratingService = ratingService;
	}

	@GetMapping
	public String showGames(Model theModel) {
		
		// create alphabet list
		List<Character> chars = new ArrayList<>();
		for (char c = 'A'; c <= 'Z'; ++c)
			chars.add(c);
		
		List<Game> games = gameService.findAll();
		
		theModel.addAttribute("chars", chars);
		theModel.addAttribute("games", games);
		
		return "games";
	}
	
	@GetMapping("/{gameId}")
	public String showGame(@PathVariable int gameId, Model theModel) {
		
		Game theGame = gameService.findById(gameId);
		Rating theRating = ratingService.findByGame(theGame);
		Testimonial theTestimonial  = testimonialService.findByGame(theGame);
		
		theModel.addAttribute("game", theGame);
		theModel.addAttribute("rating", theRating);
		theModel.addAttribute("testimonial", theTestimonial);
		
		return "game-single";
	}
	
}
