package com.abs.input;

import java.sql.Date;
import java.sql.Time;

import com.abs.db.DBName;
import com.abs.factory.DaoFactory;
import com.abs.model.Flight;

public class AddFlight {
	private static Flight flight = null;
	
	//	airline_1  MU(东方航空), airline_2  CZ(南方航空), airline_3  CA(中国国航)
	public static void muAddFlight(Flight flight) throws Exception {
		flight.setAirlineCode("MU");
		DaoFactory.getFlightDaoInstance(DBName.AIRLINE_1).add(flight);
	}
	public static void czAddFlight(Flight flight) throws Exception {
		flight.setAirlineCode("CZ");
		DaoFactory.getFlightDaoInstance(DBName.AIRLINE_2).add(flight);
	}
	public static void caAddFlight(Flight flight) throws Exception {
		flight.setAirlineCode("CA");
		DaoFactory.getFlightDaoInstance(DBName.AIRLINE_3).add(flight);
	}
	
	public static void addToAirline(int airline) throws Exception {
		switch (airline) {
		case 1: muAddFlight(flight); break;
		case 2: czAddFlight(flight); break;
		case 3: caAddFlight(flight); break;
		default: break;
		}
	}
	
	public static void addFlight(Flight flight, int airline) throws Exception {
		// TODO Auto-generated method stub

		AddFlight.flight = flight;
		addToAirline(airline);

	}
}
/*
{"whs", "天河国际机场", "武汉"}	{"shs", "浦东国际机场", "上海"}
{"bjs", "首都国际机场", "北京"}	{"szs", "深圳国际机场", "深圳"}
{"gzs", "广州国际机场", "广州"}	{"cds", "成都国际机场", "成都"}
{"sys", "沈阳国际机场", "沈阳"}	{"xzs", "西藏国际机场", "西藏"}
{"空客A380", "大"}	{"空客A320", "中"}
{"波音747", "大"}	{"波音737", "中"}
*/
