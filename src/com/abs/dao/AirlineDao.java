package com.abs.dao;

import java.util.List;

import com.abs.model.Airline;

public interface AirlineDao {

	public boolean add(Airline airline) throws Exception;
	public Airline findByCode(String code) throws Exception;
	public List<Airline> findAll() throws Exception;
}
