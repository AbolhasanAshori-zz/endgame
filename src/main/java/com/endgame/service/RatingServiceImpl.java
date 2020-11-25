package com.endgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endgame.dao.RatingRepository;
import com.endgame.entity.Game;
import com.endgame.entity.Rating;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepo;
	
	@Override
	public Rating findByGame(Game game) {
		return ratingRepo.findByGame(game);
	}

	@Override
	public List<Rating> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating findById(Integer theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Rating object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer theId) {
		// TODO Auto-generated method stub
		
	}

}
