package com.abs.factory;

import com.abs.dao.*;
import com.abs.service.*;
import com.abs.db.DBName;

public class DaoFactory {

	public static AirlineDao getAirlineDaoInstance(DBName dbName) throws Exception {
		return new AirlineService(dbName);
	}
	
	public static AirplaneDao getAirplaneDaoInstance(DBName dbName) throws Exception {
		return new AirplaneService(dbName);
	}
	
	public static AirportDao getAirportDaoInstance(DBName dbName) throws Exception {
		return new AirportService(dbName);
	}
	
	public static FlightDao getFlightDaoInstance(DBName dbName) throws Exception {
		return new FlightService(dbName);
	}
	
	public static FlightInfoDao getFlightInfoDaoInstance(DBName	dbName) throws Exception {
		return new FlightInfoService(dbName);
	}
	
	public static OrdersDao getOrdersDaoInstance(DBName dbName) throws Exception {
		return new OrdersService(dbName);
	}
	
	public static PassengerDao getPassengerDaoInstance(DBName dbName) throws Exception {
		return new PassengerService(dbName);
	}
	
	public static SeatDao getSeatDaoInstance(DBName dbName) throws Exception {
		return new SeatService(dbName);
	}
	
	public static TripDao getTripDaoInstance(DBName dbName) throws Exception {
		return new TripService(dbName);
	}
}
