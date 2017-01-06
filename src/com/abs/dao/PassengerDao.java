package com.abs.dao;

import java.util.List;

import com.abs.model.Passenger;

public interface PassengerDao {

	public boolean add(Passenger passenger) throws Exception;
	public Passenger findByPassport(String passport) throws Exception;
	public List<Passenger> findByName(String name) throws Exception;
}
