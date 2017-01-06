package com.abs.service;

import com.abs.dao.AirportDao;
import com.abs.dao.impl.AirportDaoImpl;
import com.abs.db.DBConnection;
import com.abs.db.DBName;
import com.abs.model.Airport;

public class AirportService implements AirportDao {
	
	private DBConnection dbconn = null;
	private AirportDao	dao = null;
	
	public AirportService(DBName dbName) throws Exception {
		// TODO Auto-generated constructor stub
		this.dbconn = new DBConnection();
		this.dao = new AirportDaoImpl(dbconn.getConnection(dbName));
	}

	@Override
	public boolean add(Airport airport) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.add(airport);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return flag;
	}

	@Override
	public Airport findByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		Airport airport = null;
		try {
			airport = this.dao.findByCode(code);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return airport;
	}

}
