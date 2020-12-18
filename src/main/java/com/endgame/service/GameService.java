package com.endgame.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.endgame.entity.Game;

public interface GameService extends CrudService<Game, Integer>{

	Page<Game> findAll(Pageable pageable);

	Page<Game> filterGames(Map<String, String> requestParams);
}
