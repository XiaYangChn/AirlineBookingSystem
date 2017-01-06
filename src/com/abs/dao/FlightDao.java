package com.abs.dao;

import java.util.List;

import com.abs.model.Flight;

public interface FlightDao {

	public boolean add(Flight flight) throws Exception;
	public Flight findByID(int id) throws Exception;
	public List<Flight> findAll() throws Exception;
}
