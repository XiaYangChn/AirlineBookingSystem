package com.abs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

import com.abs.dao.FlightDao;
import com.abs.db.DBName;
import com.abs.factory.DaoFactory;
import com.abs.model.Flight;

public class FlightDaoImpl implements FlightDao {
	
	private Connection conn = null;
	private	PreparedStatement pstmt = null;
	
	public FlightDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}
	
	@Override
	public boolean add(Flight flight) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into flight(id, airlineCode, number, depatureDate, depatureTime, arrivalDate, arrivalTime, fare, "
				+ "depatureAirport, arrivalAirport, airplaneName, airplaneType) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, flight.getId());
		this.pstmt.setString(2, flight.getAirlineCode());
		this.pstmt.setInt(3, flight.getNumber());
		this.pstmt.setDate(4, flight.getDepatureDate());
		this.pstmt.setTime(5, flight.getDepatureTime());
		this.pstmt.setDate(6, flight.getArrivalDate());
		this.pstmt.setTime(7, flight.getArrivalTime());
		this.pstmt.setDouble(8, flight.getFare());
		this.pstmt.setString(9, flight.getDepatureAirport());
		this.pstmt.setString(10, flight.getArrivalAirport());
		this.pstmt.setString(11, flight.getAirplaneName());
		this.pstmt.setString(12, flight.getAirplaneType());
		
		int update = this.pstmt.executeUpdate();
		this.pstmt.close();
		if(update > 0){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Flight findByID(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from flight where id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		Flight flight = null;
		if(resultSet.next()){
			flight = new Flight();
			flight.setId(resultSet.getInt(1));
			flight.setAirlineCode(resultSet.getString(2));
			flight.setNumber(resultSet.getInt(3));
			flight.setDepatureDate(resultSet.getDate(4));
			flight.setDepatureTime(resultSet.getTime(5));
			flight.setArrivalDate(resultSet.getDate(6));
			flight.setArrivalTime(resultSet.getTime(7));
			flight.setFare(resultSet.getDouble(8));
			flight.setDepatureAirport(resultSet.getString(9));
			flight.setArrivalAirport(resultSet.getString(10));
			flight.setAirplaneName(resultSet.getString(11));
			flight.setAirplaneType(resultSet.getString(12));
		}
		this.pstmt.close();
		return flight;
	}

	@Override
	public List<Flight> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from flight";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		List<Flight> list = new ArrayList<>();
		Flight flight = null;
		while(resultSet.next()){
			flight = new Flight();
			flight.setId(resultSet.getInt(1));
			flight.setAirlineCode(resultSet.getString(2));
			flight.setNumber(resultSet.getInt(3));
			flight.setDepatureDate(resultSet.getDate(4));
			flight.setDepatureTime(resultSet.getTime(5));
			flight.setArrivalDate(resultSet.getDate(6));
			flight.setArrivalTime(resultSet.getTime(7));
			flight.setFare(resultSet.getDouble(8));
			flight.setDepatureAirport(resultSet.getString(9));
			flight.setArrivalAirport(resultSet.getString(10));
			flight.setAirplaneName(resultSet.getString(11));
			flight.setAirplaneType(resultSet.getString(12));
		}
		this.pstmt.close();
		return list;
	}

	public static void main(String agrs[]) throws Exception {
		Flight flight = new Flight();
		flight.setNumber(123);
		flight.setDepatureDate(new Date(new java.util.Date().getTime()));
		flight.setDepatureTime(new Time(new java.util.Date().getTime()));
		flight.setArrivalDate(new Date(new java.util.Date().getTime()));
		flight.setArrivalTime(new Time(new java.util.Date().getTime()));
		flight.setFare(599.0);
		flight.setDepatureAirport("ecb");
		flight.setArrivalAirport("abc");
		flight.setAirplaneName("空客A320");
		flight.setAirplaneType("中");
		
		DaoFactory.getFlightDaoInstance(DBName.AIRLINE_1).add(flight);
	}
}
