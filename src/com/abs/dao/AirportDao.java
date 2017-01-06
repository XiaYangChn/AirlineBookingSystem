package com.abs.dao;

import com.abs.model.Airport;

public interface AirportDao {

	public boolean add(Airport airport) throws Exception;
	public Airport findByCode(String code) throws Exception;
}
