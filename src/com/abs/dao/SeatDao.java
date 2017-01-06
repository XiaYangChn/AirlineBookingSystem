package com.abs.dao;

import java.util.List;

import com.abs.model.Seat;

public interface SeatDao {

	public boolean add(Seat seat) throws Exception;
	public boolean modify(Seat seat) throws Exception;
	public List<Seat> findByFlightID(int flightID) throws Exception;
	public List<Seat> findEmptySeatByFlightID(int flightID) throws Exception;
}
