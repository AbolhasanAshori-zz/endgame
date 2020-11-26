package com.endgame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endgame.dao.CategoryRepository;
import com.endgame.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(Integer theId) {
		Optional<Category> result = categoryRepository.findById(theId);

		Category category;

		if (result.isPresent())
			category = result.get();
		else
			throw new RuntimeException("Category did not found!");

		return category;
	}

	@Override
	public void save(Category object) {
		categoryRepository.save(object);
	}

	@Override
	public void deleteById(Integer theId) {
		categoryRepository.deleteById(theId);
	}
}