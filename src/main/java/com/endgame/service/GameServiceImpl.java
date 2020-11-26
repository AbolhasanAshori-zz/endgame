package com.endgame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endgame.dao.GameRepository;
import com.endgame.entity.Game;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gameRepository;
	
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

}
