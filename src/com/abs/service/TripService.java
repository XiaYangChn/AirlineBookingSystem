package com.abs.service;

import com.abs.dao.TripDao;
import com.abs.dao.impl.TripDaoImpl;
import com.abs.db.DBConnection;
import com.abs.db.DBName;
import com.abs.model.Trip;

public class TripService implements TripDao {
	
	private DBConnection dbconn = null;
	private	TripDao	dao = null;
	
	public TripService(DBName dbName) throws Exception {
		// TODO Auto-generated constructor stub
		this.dbconn = new DBConnection();
		this.dao = new TripDaoImpl(dbconn.getConnection(dbName));
	}

	@Override
	public boolean add(Trip trip) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.add(trip);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return flag;
	}

	@Override
	public Trip findByID(int id) throws Exception {
		// TODO Auto-generated method stub
		Trip trip = null;
		try {
			trip = this.dao.findByID(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return trip;
	}

}
