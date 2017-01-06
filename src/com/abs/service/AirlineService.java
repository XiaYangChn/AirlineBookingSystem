package com.abs.service;

import java.util.List;

import com.abs.dao.AirlineDao;
import com.abs.dao.impl.AirlineDaoImpl;
import com.abs.db.DBConnection;
import com.abs.db.DBName;
import com.abs.model.Airline;

public class AirlineService implements AirlineDao {
	
	private DBConnection dbconn = null;
	private AirlineDao 	AirlineDao = null;
	private AirlineDao	ABSDao = null;
	
	public AirlineService(DBName dbName) throws Exception {
		// TODO Auto-generated constructor stub
		this.dbconn = new DBConnection();
		this.AirlineDao = new AirlineDaoImpl(dbconn.getConnection(dbName));
		this.ABSDao = new AirlineDaoImpl(dbconn.getConnection(DBName.ABS));
	}

	@Override
	public boolean add(Airline airline) throws Exception {
		// TODO Auto-generated method stub
		boolean airlineFlag = false;
		boolean	ABSFlag = false;
		try {
			airlineFlag = this.AirlineDao.add(airline);
			ABSFlag = this.ABSDao.add(airline);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		
		return (airlineFlag && ABSFlag);
	}

	@Override
	public Airline findByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		Airline airline = null;
		try {
			airline = this.ABSDao.findByCode(code);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		
		return airline;
	}

	@Override
	public List<Airline> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Airline> list = null;
		try {
			list = this.ABSDao.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		
		return list;
	}

}
