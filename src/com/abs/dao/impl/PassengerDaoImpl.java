package com.abs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.abs.dao.PassengerDao;
import com.abs.model.Passenger;

public class PassengerDaoImpl implements PassengerDao {
	
	private Connection conn = null;
	private	PreparedStatement pstmt = null;
	
	public PassengerDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}
	
	@Override
	public boolean add(Passenger passenger) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into passenger(passport, name) values(?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, passenger.getPassport());
		this.pstmt.setString(2, passenger.getName());
		
		int update = this.pstmt.executeUpdate();
		this.pstmt.close();
		if(update > 0){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Passenger findByPassport(String passport) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from passenger where passport=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, passport);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		Passenger passenger = null;
		if(resultSet.next()){
			passenger = new Passenger();
			passenger.setPassport(resultSet.getString(1));
			passenger.setName(resultSet.getString(2));
		}
		this.pstmt.close();
		return passenger;
	}

	@Override
	public List<Passenger> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from passenger where name=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, name);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		List<Passenger> list = new ArrayList<>();
		Passenger passenger = null;
		if(resultSet.next()){
			passenger = new Passenger();
			passenger.setPassport(resultSet.getString(1));
			passenger.setName(resultSet.getString(2));
			list.add(passenger);
		}
		this.pstmt.close();
		return list;
	}

}
