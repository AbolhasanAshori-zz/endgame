package com.endgame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endgame.dao.PlatformRepository;
import com.endgame.entity.Platform;

@Service
public class PlatformServiceImpl implements PlatformService {

	@Autowired
	private PlatformRepository platformRepository;

	@Override
	public List<Platform> findAll() {
		return platformRepository.findAll();
	}

	@Override
	public Platform findById(Integer theId) {
		Optional<Platform> result = platformRepository.findById(theId);

		Platform platform;

		if (result.isPresent())
			platform = result.get();
		else
			throw new RuntimeException("Platform did not found!");

		return platform;
	}

	@Override
	public void save(Platform object) {
		platformRepository.save(object);
	}

	@Override
	public void deleteById(Integer theId) {
		platformRepository.deleteById(theId);
	}
}