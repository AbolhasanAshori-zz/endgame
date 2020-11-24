package com.endgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endgame.dao.TestimonialRepository;
import com.endgame.entity.Game;
import com.endgame.entity.Testimonial;

@Service
public class TestimonialServiceImpl implements TestimonialService {

	@Autowired
	private TestimonialRepository testimonialRepo;

	@Override
	public List<Testimonial> findAll() {
		return testimonialRepo.findAll();
	}

	@Override
	public Testimonial findById(Integer theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Testimonial object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer theId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Testimonial findByGame(Game game) {
		return testimonialRepo.findByGame(game);
	}
}
