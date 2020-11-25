package com.endgame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.endgame.entity.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

}
