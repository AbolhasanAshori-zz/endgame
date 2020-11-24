package com.endgame.service;

import com.endgame.entity.Game;
import com.endgame.entity.Rating;

public interface RatingService extends CrudService<Rating, Integer>{

	public Rating findByGame(Game game);
}
