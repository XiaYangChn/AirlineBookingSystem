package com.abs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.abs.dao.AirportDao;
import com.abs.model.Airport;

public class AirportDaoImpl implements AirportDao {
	
	private Connection conn = null;
	private	PreparedStatement pstmt = null;
	
	public AirportDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}
	
	@Override
	public boolean add(Airport airport) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into airport(code, name, city, country, connTime) values(?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, airport.getCode());
		this.pstmt.setString(2, airport.getName());
		this.pstmt.setString(3, airport.getCity());
		this.pstmt.setString(4, airport.getCountry());
		this.pstmt.setInt(5, airport.getConnTime());
		
		int update = this.pstmt.executeUpdate();
		this.pstmt.close();
		if(update > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Airport findByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from airport where code=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, code);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		Airport airport = null;
		if(resultSet.next()){
			airport = new Airport();
			airport.setCode(resultSet.getString(1));
			airport.setName(resultSet.getString(2));
			airport.setCity(resultSet.getString(3));
			airport.setCountry(resultSet.getString(4));
			airport.setConnTime(resultSet.getInt(5));
		}
		this.pstmt.close();
		return airport;
	}

}
