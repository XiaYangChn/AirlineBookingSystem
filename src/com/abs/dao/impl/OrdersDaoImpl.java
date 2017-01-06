package com.abs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.abs.dao.OrdersDao;
import com.abs.model.Orders;

public class OrdersDaoImpl implements OrdersDao {
	
	private Connection conn = null;
	private	PreparedStatement pstmt = null;
	
	public OrdersDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}
	
	@Override
	public boolean add(Orders orders) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into orders(id, tripID, createDate, createTime, totalFare, "
				+ "contactName, contactPhone) values(?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, orders.getId());
		this.pstmt.setInt(2, orders.getTripID());
		this.pstmt.setDate(3, orders.getCreateDate());
		this.pstmt.setTime(4, orders.getCreateTime());
		this.pstmt.setDouble(5, orders.getTotalFare());
		this.pstmt.setString(6, orders.getContactName());
		this.pstmt.setString(7, orders.getContactPhone());
		
		int update = this.pstmt.executeUpdate();
		this.pstmt.close();
		if(update > 0){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Orders> findByID(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from orders where id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		List<Orders> list = new ArrayList<>();
		Orders orders = null;
		while(resultSet.next()){
			orders = new Orders();
			orders.setId(resultSet.getInt(1));
			orders.setTripID(resultSet.getInt(2));
			orders.setCreateDate(resultSet.getDate(3));
			orders.setCreateTime(resultSet.getTime(4));
			orders.setTotalFare(resultSet.getDouble(5));
			orders.setContactName(resultSet.getString(6));
			orders.setContactPhone(resultSet.getString(7));
			list.add(orders);
		}
		this.pstmt.close();
		return list;
	}

	@Override
	public List<Orders> findByContactName(String contactName) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from orders where contactName=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, contactName);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		List<Orders> list = new ArrayList<>();
		Orders orders = null;
		while(resultSet.next()){
			orders = new Orders();
			orders.setId(resultSet.getInt(1));
			orders.setTripID(resultSet.getInt(2));
			orders.setCreateDate(resultSet.getDate(3));
			orders.setCreateTime(resultSet.getTime(4));
			orders.setTotalFare(resultSet.getDouble(5));
			orders.setContactName(resultSet.getString(6));
			orders.setContactPhone(resultSet.getString(7));
			list.add(orders);
		}
		this.pstmt.close();
		return list;
	}

	@Override
	public List<Orders> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from orders";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet resultSet = this.pstmt.executeQuery();
		
		List<Orders> list = new ArrayList<>();
		Orders orders = null;
		while(resultSet.next()){
			orders = new Orders();
			orders.setId(resultSet.getInt(1));
			orders.setTripID(resultSet.getInt(2));
			orders.setCreateDate(resultSet.getDate(3));
			orders.setCreateTime(resultSet.getTime(4));
			orders.setTotalFare(resultSet.getDouble(5));
			orders.setContactName(resultSet.getString(6));
			orders.setContactPhone(resultSet.getString(7));
			list.add(orders);
		}
		this.pstmt.close();
		return list;
	}

}
