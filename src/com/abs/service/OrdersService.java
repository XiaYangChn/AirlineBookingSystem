package com.abs.service;

import java.util.List;

import com.abs.dao.OrdersDao;
import com.abs.dao.impl.OrdersDaoImpl;
import com.abs.db.DBConnection;
import com.abs.db.DBName;
import com.abs.model.Orders;

public class OrdersService implements OrdersDao {
	
	private DBConnection dbconn = null;
	private OrdersDao	dao = null;
	
	public OrdersService(DBName dbName) throws Exception {
		// TODO Auto-generated constructor stub
		this.dbconn = new DBConnection();
		this.dao = new OrdersDaoImpl(dbconn.getConnection(dbName));
	}

	@Override
	public boolean add(Orders orders) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.add(orders);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return flag;
	}

	@Override
	public List<Orders> findByID(int id) throws Exception {
		// TODO Auto-generated method stub
		List<Orders> list = null;
		try {
			list = this.dao.findByID(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return list;
	}

	@Override
	public List<Orders> findByContactName(String contactName) throws Exception {
		// TODO Auto-generated method stub
		List<Orders> list = null;
		try {
			list = this.dao.findByContactName(contactName);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return list;
	}

	@Override
	public List<Orders> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Orders> list = null;
		try {
			list = this.dao.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return list;
	}

}
