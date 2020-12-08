package com.endgame.service;

import com.endgame.dao.GameRepository;
import com.endgame.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

	private GameRepository gameRepository;

	private PlatformService platformService;
	private CategoryService categoryService;
	private GenreService genreService;

	public GameServiceImpl() {

	}

	@Autowired
	public GameServiceImpl(GameRepository gameRepository, PlatformService platformService, CategoryService categoryService, GenreService genreService) {
		this.gameRepository = gameRepository;
		this.platformService = platformService;
		this.categoryService = categoryService;
		this.genreService = genreService;
	}

	@Override
	public List<Game> findAll() {
		return gameRepository.findAll();
	}

	@Override
	public Game findById(Integer theId) {
		Optional<Game> result = gameRepository.findById(theId);
		
		Game game;
		
		if (result.isPresent())
			game = result.get();
		else
			throw new RuntimeException("Game did not found!");
		
		return game;
	}

	@Override
	public void save(Game object) {
		gameRepository.save(object);
	}

	@Override
	public void deleteById(Integer theId) {
		gameRepository.deleteById(theId);
	}

	@Override
	public Page<Game> findAll(Pageable pageable) {
		return gameRepository.findAll(pageable);
	}

	@Override
	public Page<Game> filterGames(Map<String, String> requestParams) {
		String character = requestParams.get("char");

		int page = requestParams.get("page") != null ? Integer.parseInt(requestParams.get("page")) - 1 : 0;
		int size = 3;
		int id;

		List<Game> filteredGames = character != null ? gameRepository.findByTitleStartingWith(character) : gameRepository.findAll(Sort.by("title"));
		List<Game> allGames;
		List<Game> resultGames = null;

		if (!filteredGames.isEmpty()) {
			for (Map.Entry<String, String> requestParam : requestParams.entrySet()) {
				switch (requestParam.getKey()) {
					case "platform":
						id = Integer.parseInt(requestParam.getValue());
						allGames = platformService.findById(id).getGames();
						filteredGames.retainAll(allGames);
						break;
					case "category":
						id = Integer.parseInt(requestParam.getValue());
						allGames = categoryService.findById(id).getGames();
						filteredGames.retainAll(allGames);
						break;
					case "genre":
						id = Integer.parseInt(requestParam.getValue());
						allGames = genreService.findById(id).getGames();
						filteredGames.retainAll(allGames);
						break;
				}
			}

			int start = page * size;
			int end = ((page + 1) * size);

			if (filteredGames.size() - 1 >= start) {
				if (filteredGames.size() - 1 >= end)
					resultGames = filteredGames.subList(start, end);
				else
					resultGames = filteredGames.subList(start, filteredGames.size());
			}
		}

		return new PageImpl<>(resultGames, PageRequest.of(page, size), filteredGames.size());
	}
}
