package com.endgame.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.endgame.entity.Category;
import com.endgame.entity.Game;
import com.endgame.entity.Genre;
import com.endgame.entity.Platform;
import com.endgame.entity.Rating;
import com.endgame.entity.Testimonial;
import com.endgame.service.CategoryService;
import com.endgame.service.GameService;
import com.endgame.service.GenreService;
import com.endgame.service.PlatformService;
import com.endgame.service.RatingService;
import com.endgame.service.TestimonialService;

@Controller
@RequestMapping("/games")
public class GamesController {

	// Services
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
	                       RatingService ratingService, CategoryService categoryService,
	                       PlatformService platformService, GenreService genreService) {
		this.gameService = gameService;
		this.testimonialService = testimonialService;
		this.ratingService = ratingService;
		this.categoryService = categoryService;
		this.platformService = platformService;
		this.genreService = genreService;
	}

	@GetMapping
	public String showGames(@RequestParam(required = false) Map<String, String> requestParams,
	                        Model theModel) {
		Page<Game> gamesPage;
		List<Game> games;

		// create alphabet list
		List<Character> chars = new ArrayList<>();
		for (char c = 'A'; c <= 'Z'; ++c)
			chars.add(c);

		if (requestParams.isEmpty()) {
			gamesPage = gameService.findAll(PageRequest.of(0, 3, Sort.by("title")));
			games = gamesPage.toList();
		} else {
			gamesPage = gameService.filterGames(requestParams);
			games = gamesPage.toList();
		}

		List<Category> categories = categoryService.findAll();
		List<Platform> platforms = platformService.findAll();
		List<Genre> genres = genreService.findAll();

		theModel.addAttribute("chars", chars);
		theModel.addAttribute("categories", categories);
		theModel.addAttribute("platforms", platforms);
		theModel.addAttribute("genres", genres);

		theModel.addAttribute("games", games);
		theModel.addAttribute("totalPages", gamesPage.getTotalPages());

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
