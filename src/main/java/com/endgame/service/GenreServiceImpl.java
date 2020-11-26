package com.endgame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endgame.dao.GenreRepository;
import com.endgame.entity.Genre;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository genreRepository;

	@Override
	public List<Genre> findAll() {
		return genreRepository.findAll();
	}

	@Override
	public Genre findById(Integer theId) {
		Optional<Genre> result = genreRepository.findById(theId);

		Genre genre;

		if (result.isPresent())
			genre = result.get();
		else
			throw new RuntimeException("Genre did not found!");

		return genre;
	}

	@Override
	public void save(Genre object) {
		genreRepository.save(object);
	}

	@Override
	public void deleteById(Integer theId) {
		genreRepository.deleteById(theId);
	}
}