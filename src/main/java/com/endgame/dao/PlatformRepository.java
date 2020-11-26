package com.endgame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.endgame.entity.Platform;

public interface PlatformRepository extends JpaRepository<Platform, Integer> {

}