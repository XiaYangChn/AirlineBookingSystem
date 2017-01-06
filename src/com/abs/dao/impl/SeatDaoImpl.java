package com.abs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.abs.dao.SeatDao;
import com.abs.model.Seat;

public class SeatDaoImpl implements SeatDao {
	
	private Connection conn = null;
	private	PreparedStatement pstmt = null;
	
	public SeatDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}
	
	@Override
	public boolean add(Seat seat) throws Exception {
		// TODO Auto-generated method stub
		String	sql = "insert into seat(relativeID, row, num, type, flightID) "
				+ "values(?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, seat.getId());
		this.pstmt.setInt(2, seat.getRow());
		this.pstmt.setInt(3, seat.getNum());
		this.pstmt.setString(4, seat.getType());
		this.pstmt.setInt(5, seat.getFlightID());
		
		int update = this.pstmt.executeUpdate();
		this.pstmt.close();
		if(update > 0){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean modify(Seat seat) throws Exception {
		// TODO Auto-generated method stub
		String	sql = "update seat set passport=? where id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, seat.getPassport());
		this.pstmt.setInt(2, seat.getId());

		int update = this.pstmt.executeUpdate();
		this.pstmt.close();
		if(update > 0){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Seat> findByFlightID(int flightID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from seat where flightID=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, flightID);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		List<Seat> list = new ArrayList<>();
		Seat seat = null;
		while(resultSet.next()){
			seat = new Seat();
			seat.setId(resultSet.getInt(1));
			seat.setRelativeID(resultSet.getInt(2));
			seat.setRow(resultSet.getInt(3));
			seat.setNum(resultSet.getInt(4));
			seat.setType(resultSet.getString(5));
			seat.setFlightID(resultSet.getInt(6));
			seat.setPassport(resultSet.getString(7));
			list.add(seat);
		}
		this.pstmt.close();
		return list;
	}

	@Override
	public List<Seat> findEmptySeatByFlightID(int flightID) throws Exception {
		// TODO Auto-generated method stub
				String sql = "select * from seat where flightID=? and passport is null";
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, flightID);
				ResultSet resultSet = this.pstmt.executeQuery();
				
				List<Seat> list = new ArrayList<>();
				Seat seat = null;
				while(resultSet.next()){
					seat = new Seat();
					seat.setId(resultSet.getInt(1));
					seat.setRelativeID(resultSet.getInt(2));
					seat.setRow(resultSet.getInt(3));
					seat.setNum(resultSet.getInt(4));
					seat.setType(resultSet.getString(5));
					seat.setFlightID(resultSet.getInt(6));
					//seat.setPassport(resultSet.getString(7));	//	null;
					list.add(seat);
				}
				this.pstmt.close();
				return list;
	}

}
