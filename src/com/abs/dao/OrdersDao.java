package com.abs.dao;

import java.util.List;

import com.abs.model.Orders;

public interface OrdersDao {

	public boolean add(Orders orders) throws Exception;
	public List<Orders> findByID(int id) throws Exception;
	public List<Orders> findByContactName(String contactName) throws Exception;
	public List<Orders> findAll() throws Exception;
}
