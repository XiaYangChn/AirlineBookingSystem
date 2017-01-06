package com.abs.service;

import com.abs.dao.AirplaneDao;
import com.abs.dao.impl.AirplaneDaoImpl;
import com.abs.db.DBConnection;
import com.abs.db.DBName;
import com.abs.model.Airplane;

public class AirplaneService implements AirplaneDao {
	
	private DBConnection dbconn = null;
	private AirplaneDao dao = null;
	
	public AirplaneService(DBName dbName) throws Exception {
		// TODO Auto-generated constructor stub
		this.dbconn = new DBConnection();
		this.dao = new AirplaneDaoImpl(dbconn.getConnection(dbName));
	}

	@Override
	public boolean add(Airplane airplane) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.add(airplane);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return flag;
	}

	@Override
	public Airplane findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		Airplane airplane = null;
		try {
			airplane = this.dao.findByName(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return airplane;
	}

}
