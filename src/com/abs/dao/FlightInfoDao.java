package com.abs.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.abs.model.FlightInfo;

public interface FlightInfoDao {

	public boolean add(FlightInfo flightInfo) throws Exception;
	public FlightInfo findByID(int id) throws Exception;
	public List<FlightInfo> findByAirport(String depatureAirportCity, String arrivalAirportCity, Date depatureDate) throws Exception;
	public List<FlightInfo> findByDepatureAirport(String depatureAirportCity, Date depatureDate) throws Exception;
	public List<FlightInfo> findByTransferArrivalAirport(String depatureAirportCity, String arrivalAirportCity, Date depatureDate, Time depatureTime) throws Exception;
	public int addPassenger(int id) throws Exception;
}
