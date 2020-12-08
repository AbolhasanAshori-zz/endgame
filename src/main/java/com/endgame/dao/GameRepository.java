package com.endgame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.endgame.entity.Game;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

	List<Game> findByTitleStartingWith(String character);

}
