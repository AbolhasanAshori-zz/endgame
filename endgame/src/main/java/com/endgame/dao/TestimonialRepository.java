package com.endgame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.endgame.entity.Game;
import com.endgame.entity.Testimonial;

public interface TestimonialRepository extends JpaRepository<Testimonial, Integer>{

	public Testimonial findByGame(Game game);
	
}
