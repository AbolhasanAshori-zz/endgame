package com.endgame.service;

import com.endgame.entity.Game;
import com.endgame.entity.Testimonial;

public interface TestimonialService extends CrudService<Testimonial, Integer> {

	public Testimonial findByGame(Game game);
}
