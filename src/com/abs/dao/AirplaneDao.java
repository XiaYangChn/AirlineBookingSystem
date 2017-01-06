package com.abs.dao;

import com.abs.model.Airplane;

public interface AirplaneDao {

	public boolean add(Airplane airplane) throws Exception;
	public Airplane findByName(String name) throws Exception;
}
