package com.endgame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.endgame.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

}