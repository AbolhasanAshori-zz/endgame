package com.endgame.controller;

import java.util.ArrayList;
import java.util.List;

import com.endgame.entity.*;
import com.endgame.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/games")
public class GamesController {

	private GameService gameService;
	private TestimonialService testimonialService;
	private RatingService ratingService;
	private CategoryService categoryService;
	private PlatformService platformService;
	private GenreService genreService;

	public GamesController() {

	}

	@Autowired
	public GamesController(GameService gameService, TestimonialService testimonialService,
	                       RatingService ratingService, CategoryService categoryService, PlatformService platformService, GenreService genreService) {
		this.gameService = gameService;
		this.testimonialService = testimonialService;
		this.ratingService = ratingService;
		this.categoryService = categoryService;
		this.platformService = platformService;
		this.genreService = genreService;
	}

	@GetMapping
	public String showGames(Model theModel) {

		// create alphabet list
		List<Character> chars = new ArrayList<>();
		for (char c = 'A'; c <= 'Z'; ++c)
			chars.add(c);

		List<Game> games = gameService.findAll();
		List<Category> categories = categoryService.findAll();
		List<Platform> platforms = platformService.findAll();
		List<Genre> genres = genreService.findAll();

		theModel.addAttribute("chars", chars);
		theModel.addAttribute("games", games);
		theModel.addAttribute("categories", categories);
		theModel.addAttribute("platforms", platforms);
		theModel.addAttribute("genres", genres);

		return "games";
	}

	@GetMapping("/{gameId}")
	public String showGame(@PathVariable int gameId, Model theModel) {

		Game theGame = gameService.findById(gameId);
		Rating theRating = ratingService.findByGame(theGame);
		Testimonial theTestimonial = testimonialService.findByGame(theGame);

		theModel.addAttribute("game", theGame);
		theModel.addAttribute("rating", theRating);
		theModel.addAttribute("testimonial", theTestimonial);

		return "game-single";
	}

}
