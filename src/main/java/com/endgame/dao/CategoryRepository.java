package com.endgame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.endgame.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}