package com.endgame.service;

import com.endgame.entity.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface GameService extends CrudService<Game, Integer>{

	Page<Game> findAll(Pageable pageable);

	Page<Game> filterGames(Map<String, String> requestParams);
}
