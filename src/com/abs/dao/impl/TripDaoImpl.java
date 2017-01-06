package com.abs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.abs.dao.TripDao;
import com.abs.model.Trip;

public class TripDaoImpl implements TripDao {
	
	private Connection conn = null;
	private	PreparedStatement pstmt = null;
	
	public TripDaoImpl(Connection conn){
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}
	
	@Override
	public boolean add(Trip trip) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into trip(id, flightInfoID, fare, passport, seatID) "
				+ "values(?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, trip.getId());
		this.pstmt.setInt(2, trip.getFlightInfoID());
		this.pstmt.setDouble(3, trip.getFare());
		this.pstmt.setString(4, trip.getPassport());
		this.pstmt.setInt(5, trip.getSeatID());
		
		int update = this.pstmt.executeUpdate();
		this.pstmt.close();
		if(update > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Trip findByID(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from trip where id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		Trip trip = null;
		if(resultSet.next()){
			trip = new Trip();
			trip.setId(resultSet.getInt(1));
			trip.setFlightInfoID(resultSet.getInt(2));
			trip.setFare(resultSet.getDouble(3));
			trip.setPassport(resultSet.getString(4));
			trip.setSeatID(resultSet.getInt(5));
		}
		this.pstmt.close();
		return trip;
	}

}
