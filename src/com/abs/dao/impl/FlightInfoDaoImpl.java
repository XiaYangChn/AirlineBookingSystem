package com.abs.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.abs.dao.FlightInfoDao;
import com.abs.db.DBName;
import com.abs.factory.DaoFactory;
import com.abs.model.FlightInfo;

public class FlightInfoDaoImpl implements FlightInfoDao {
	
	private Connection conn = null;
	private	PreparedStatement pstmt = null;
	
	public FlightInfoDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}
	
	@Override
	public boolean add(FlightInfo flightInfo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into flightInfo(airlineCode, flightID, number, "
				+ "depatureDate, depatureTime, arrivalDate, arrivalTime,"
				+ "fare, depatureAirport, arrivalAirport, airlineName, airplaneName,"
				+ "airplaneType, depatureAirportName, arrivalAirportName, depatureAirportCity, arrivalAirportCity, airplaneEmptySeats) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, flightInfo.getAirlineCode());
		this.pstmt.setInt(2, flightInfo.getFlightID());
		this.pstmt.setInt(3, flightInfo.getNumber());
		this.pstmt.setDate(4, flightInfo.getDepatureDate());
		this.pstmt.setTime(5, flightInfo.getDepatureTime());
		this.pstmt.setDate(6, flightInfo.getArrivalDate());
		this.pstmt.setTime(7, flightInfo.getArrivalTime());
		this.pstmt.setDouble(8, flightInfo.getFare());
		this.pstmt.setString(9, flightInfo.getDepatureAirport());
		this.pstmt.setString(10, flightInfo.getArrivalAirport());
		this.pstmt.setString(11, flightInfo.getAirlineName());
		this.pstmt.setString(12, flightInfo.getAirplaneName());
		this.pstmt.setString(13, flightInfo.getAirplaneType());
		this.pstmt.setString(14, flightInfo.getDepatureAirportName());
		this.pstmt.setString(15, flightInfo.getArrivalAirportName());
		this.pstmt.setString(16, flightInfo.getDepatureAirportCity());
		this.pstmt.setString(17, flightInfo.getArrivalAirportCity());
		this.pstmt.setInt(18, flightInfo.getAirplaneEmptySeats());
		
		int update = this.pstmt.executeUpdate();
		this.pstmt.close();
		if(update > 0){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public FlightInfo findByID(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from flightInfo where id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		FlightInfo flightInfo = null;
		if(resultSet.next()){
			flightInfo = new FlightInfo();
			flightInfo.setId(resultSet.getInt(1));
			flightInfo.setAirlineCode(resultSet.getString(2));
			flightInfo.setFlightID(resultSet.getInt(3));
			flightInfo.setNumber(resultSet.getInt(4));
			flightInfo.setDepatureDate(resultSet.getDate(5));
			flightInfo.setDepatureTime(resultSet.getTime(6));
			flightInfo.setArrivalDate(resultSet.getDate(7));
			flightInfo.setArrivalTime(resultSet.getTime(8));
			flightInfo.setFare(resultSet.getDouble(9));
			flightInfo.setDepatureAirport(resultSet.getString(10));
			flightInfo.setArrivalAirport(resultSet.getString(11));
			flightInfo.setAirlineName(resultSet.getString(12));
			flightInfo.setAirplaneName(resultSet.getString(13));
			flightInfo.setAirplaneType(resultSet.getString(14));
			flightInfo.setDepatureAirportName(resultSet.getString(15));
			flightInfo.setArrivalAirportName(resultSet.getString(16));
			flightInfo.setDepatureAirportCity(resultSet.getString(17));
			flightInfo.setArrivalAirportCity(resultSet.getString(18));
			flightInfo.setAirplaneEmptySeats(resultSet.getInt(19));
		}
		this.pstmt.close();
		return flightInfo;
	}
	
	@Override
	public List<FlightInfo> findByAirport(String depatureAirportCity, String arrivalAirportCity, Date depatureDate) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from flightInfo where depatureAirportCity=? and arrivalAirportCity=? and depatureDate=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, depatureAirportCity);
		this.pstmt.setString(2, arrivalAirportCity);
		this.pstmt.setDate(3, depatureDate);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		List<FlightInfo> list = new ArrayList<>();
		FlightInfo flightInfo = null;
		while(resultSet.next()){
			flightInfo = new FlightInfo();
			flightInfo.setId(resultSet.getInt(1));
			flightInfo.setAirlineCode(resultSet.getString(2));
			flightInfo.setFlightID(resultSet.getInt(3));
			flightInfo.setNumber(resultSet.getInt(4));
			flightInfo.setDepatureDate(resultSet.getDate(5));
			flightInfo.setDepatureTime(resultSet.getTime(6));
			flightInfo.setArrivalDate(resultSet.getDate(7));
			flightInfo.setArrivalTime(resultSet.getTime(8));
			flightInfo.setFare(resultSet.getDouble(9));
			flightInfo.setDepatureAirport(resultSet.getString(10));
			flightInfo.setArrivalAirport(resultSet.getString(11));
			flightInfo.setAirlineName(resultSet.getString(12));
			flightInfo.setAirplaneName(resultSet.getString(13));
			flightInfo.setAirplaneType(resultSet.getString(14));
			flightInfo.setDepatureAirportName(resultSet.getString(15));
			flightInfo.setArrivalAirportName(resultSet.getString(16));
			flightInfo.setDepatureAirportCity(resultSet.getString(17));
			flightInfo.setArrivalAirportCity(resultSet.getString(18));
			flightInfo.setAirplaneEmptySeats(resultSet.getInt(19));
			
			list.add(flightInfo);
		}
		this.pstmt.close();
		return list;
	}

	@Override
	public List<FlightInfo> findByDepatureAirport(String depatureAirportCity, Date depatureDate) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from flightInfo where depatureAirportCity=? and depatureDate=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, depatureAirportCity);
		this.pstmt.setDate(2, depatureDate);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		List<FlightInfo> list = new ArrayList<>();
		FlightInfo flightInfo = null;
		while(resultSet.next()){
			flightInfo = new FlightInfo();
			flightInfo.setId(resultSet.getInt(1));
			flightInfo.setAirlineCode(resultSet.getString(2));
			flightInfo.setFlightID(resultSet.getInt(3));
			flightInfo.setNumber(resultSet.getInt(4));
			flightInfo.setDepatureDate(resultSet.getDate(5));
			flightInfo.setDepatureTime(resultSet.getTime(6));
			flightInfo.setArrivalDate(resultSet.getDate(7));
			flightInfo.setArrivalTime(resultSet.getTime(8));
			flightInfo.setFare(resultSet.getDouble(9));
			flightInfo.setDepatureAirport(resultSet.getString(10));
			flightInfo.setArrivalAirport(resultSet.getString(11));
			flightInfo.setAirlineName(resultSet.getString(12));
			flightInfo.setAirplaneName(resultSet.getString(13));
			flightInfo.setAirplaneType(resultSet.getString(14));
			flightInfo.setDepatureAirportName(resultSet.getString(15));
			flightInfo.setArrivalAirportName(resultSet.getString(16));
			flightInfo.setDepatureAirportCity(resultSet.getString(17));
			flightInfo.setArrivalAirportCity(resultSet.getString(18));
			flightInfo.setAirplaneEmptySeats(resultSet.getInt(19));
			
			list.add(flightInfo);
		}
		this.pstmt.close();
		return list;
	}

	@Override
	public List<FlightInfo> findByTransferArrivalAirport(String depatureAirportCity, String arrivalAirportCity, Date depatureDate, Time depatureTime) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from flightInfo where depatureAirportCity=? and arrivalAirportCity=? and depatureDate>=? and depatureTime>=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, depatureAirportCity);
		this.pstmt.setString(2, arrivalAirportCity);
		this.pstmt.setDate(3, depatureDate);
		this.pstmt.setTime(4, depatureTime);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		List<FlightInfo> list = new ArrayList<>();
		FlightInfo flightInfo = null;
		while(resultSet.next()){
			flightInfo = new FlightInfo();
			flightInfo.setId(resultSet.getInt(1));
			flightInfo.setAirlineCode(resultSet.getString(2));
			flightInfo.setFlightID(resultSet.getInt(3));
			flightInfo.setNumber(resultSet.getInt(4));
			flightInfo.setDepatureDate(resultSet.getDate(5));
			flightInfo.setDepatureTime(resultSet.getTime(6));
			flightInfo.setArrivalDate(resultSet.getDate(7));
			flightInfo.setArrivalTime(resultSet.getTime(8));
			flightInfo.setFare(resultSet.getDouble(9));
			flightInfo.setDepatureAirport(resultSet.getString(10));
			flightInfo.setArrivalAirport(resultSet.getString(11));
			flightInfo.setAirlineName(resultSet.getString(12));
			flightInfo.setAirplaneName(resultSet.getString(13));
			flightInfo.setAirplaneType(resultSet.getString(14));
			flightInfo.setDepatureAirportName(resultSet.getString(15));
			flightInfo.setArrivalAirportName(resultSet.getString(16));
			flightInfo.setDepatureAirportCity(resultSet.getString(17));
			flightInfo.setArrivalAirportCity(resultSet.getString(18));
			flightInfo.setAirplaneEmptySeats(resultSet.getInt(19));
			
			list.add(flightInfo);
		}
		this.pstmt.close();
		return list;
	}

	@Override
	public int addPassenger(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select airplaneEmptySeats from flightInfo where id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		int emptySeats = 0;
		if(resultSet.next()){
			emptySeats = resultSet.getInt(1);
		}
		emptySeats--;
		
		sql = "update flightInfo set airplaneEmptySeats=? where id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, emptySeats);
		this.pstmt.setInt(2, id);
		this.pstmt.executeUpdate();
		this.pstmt.close();
		
		return emptySeats;
	}

	public static void main(String args[]) throws Exception {
//		FlightInfo flightInfo = new FlightInfo();
//		flightInfo.setAirlineCode("MUT");
//		flightInfo.setFlightID(1);
//		flightInfo.setNumber(123);
//		flightInfo.setDepatureDate(new Date(new java.util.Date().getTime()));
//		flightInfo.setDepatureTime(new Time(new java.util.Date().getTime()));
//		flightInfo.setArrivalDate(new Date(new java.util.Date().getTime()));
//		flightInfo.setArrivalTime(new Time(new java.util.Date().getTime()));
//		flightInfo.setFare(599.0);
//		flightInfo.setDepatureAirport("ecb");
//		flightInfo.setArrivalAirport("abc");
//		flightInfo.setAirlineName("中国南方航空");
//		flightInfo.setAirplaneName("空客A320");
//		flightInfo.setAirplaneType("中");
//		flightInfo.setDepatureAirportName("天河机场");
//		flightInfo.setDepatureAirportCity("武汉");
//		flightInfo.setArrivalAirportName("虹桥机场");
//		flightInfo.setArrivalAirportCity("上海");
//		flightInfo.setAirplaneEmptySeats(80);
//		
//		DaoFactory.getFlightInfoDaoInstance(DBName.ABS).add(flightInfo);
		
//		List<FlightInfo> arrivalList = DaoFactory.getFlightInfoDaoInstance(DBName.ABS).findByArrivalAirport("石家庄", Date.valueOf("2016-12-3"), Time.valueOf("10:00:00"));
//		System.out.println(arrivalList.size());
	}
}
