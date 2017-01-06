package com.abs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.abs.dao.AirplaneDao;
import com.abs.model.Airplane;

public class AirplaneDaoImpl implements AirplaneDao {
	
	private Connection conn = null;
	private	PreparedStatement pstmt = null;
	
	public AirplaneDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}
	
	@Override
	public boolean add(Airplane airplane) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into airplane(name, type) values(?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, airplane.getName());
		this.pstmt.setString(2, airplane.getType());
		
		int update = this.pstmt.executeUpdate();
		this.pstmt.close();
		if(update > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Airplane findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from airplane where name=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, name);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		Airplane airplane = null;
		if(resultSet.next()){
			airplane = new Airplane();
			airplane.setName(resultSet.getString(1));
			airplane.setType(resultSet.getString(2));
		}
		this.pstmt.close();
		return airplane;
	}

}
