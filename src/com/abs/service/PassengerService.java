package com.abs.service;

import java.util.List;

import com.abs.dao.PassengerDao;
import com.abs.dao.impl.PassengerDaoImpl;
import com.abs.db.DBConnection;
import com.abs.db.DBName;
import com.abs.model.Passenger;

public class PassengerService implements PassengerDao {
	
	private DBConnection dbconn = null;
	private PassengerDao	dao = null;
	
	public PassengerService(DBName dbName) throws Exception {
		// TODO Auto-generated constructor stub
		this.dbconn = new DBConnection();
		this.dao = new PassengerDaoImpl(dbconn.getConnection(dbName));
	}

	@Override
	public boolean add(Passenger passenger) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.add(passenger);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return flag;
	}

	@Override
	public Passenger findByPassport(String passport) throws Exception {
		// TODO Auto-generated method stub
		Passenger passenger = null;
		try {
			passenger = this.dao.findByPassport(passport);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return passenger;
	}

	@Override
	public List<Passenger> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		List<Passenger> list = null;
		try {
			list = this.dao.findByName(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return list;
	}

}
