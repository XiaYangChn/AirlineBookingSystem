package com.abs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.abs.dao.AirlineDao;
import com.abs.db.DBConnection;
import com.abs.db.DBName;
import com.abs.model.Airline;

public class AirlineDaoImpl implements AirlineDao {
	
	private Connection conn = null;
	private	PreparedStatement pstmt = null;
	
	public AirlineDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean add(Airline airline) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into airline(code, name, discount) values(?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, airline.getCode());
		this.pstmt.setString(2, airline.getName());
		this.pstmt.setDouble(3, airline.getDiscount());
		
		int update = this.pstmt.executeUpdate();
		this.pstmt.close();
		if(update > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Airline findByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from airline where code=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, code);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		Airline airline = null;
		if(resultSet.next()){
			airline = new Airline();
			airline.setCode(resultSet.getString(1));
			airline.setName(resultSet.getString(2));
			airline.setDiscount(resultSet.getDouble(3));
		}
		this.pstmt.close();
		return airline;
	}

	@Override
	public List<Airline> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from airline";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		List<Airline> list = new ArrayList<>();
		Airline airline = null;
		while(resultSet.next()){
			airline = new Airline();
			airline.setCode(resultSet.getString(1));
			airline.setName(resultSet.getString(2));
			airline.setDiscount(resultSet.getDouble(3));
			list.add(airline);
		}
		this.pstmt.close();
		return list;
	}

	public static void main(String args[]) throws Exception {
		Airline airline = new Airline();
		airline.setCode("MU");
		airline.setName("东方航空");
		airline.setDiscount(0.9);
		
		new AirlineDaoImpl(new DBConnection().getConnection(DBName.AIRLINE_1)).add(airline);
	}
}
