package com.endgame.service;

import java.util.List;

public interface CrudService<T, ID extends Object> {
	public List<T> findAll();
	
	public T findById(ID theId);
	
	public void save(T object);
	
	public void deleteById(ID theId);
}
