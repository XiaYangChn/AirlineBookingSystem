package com.abs.dao;

import com.abs.model.Trip;

public interface TripDao {

	public boolean add(Trip trip) throws Exception;
	public Trip findByID(int id) throws Exception;
}
