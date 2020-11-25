package com.endgame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.endgame.entity.Game;
import com.endgame.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

	public Rating findByGame(Game game);
}
