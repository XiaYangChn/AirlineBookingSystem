package com.abs.service;

import java.util.List;

import com.abs.dao.SeatDao;
import com.abs.dao.impl.SeatDaoImpl;
import com.abs.db.DBConnection;
import com.abs.db.DBName;
import com.abs.model.Seat;

public class SeatService implements SeatDao {
	
	private DBConnection dbconn = null;
	private	SeatDao	dao	= null;
	
	public SeatService(DBName dbName) throws Exception {
		// TODO Auto-generated constructor stub
		this.dbconn = new DBConnection();
		this.dao = new SeatDaoImpl(dbconn.getConnection(dbName));
	}

	@Override
	public boolean add(Seat seat) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.add(seat);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return flag;
	}

	@Override
	public boolean modify(Seat seat) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.modify(seat);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return flag;
	}

	@Override
	public List<Seat> findByFlightID(int flightID) throws Exception {
		// TODO Auto-generated method stub
		List<Seat> list = null;
		try {
			list = this.dao.findByFlightID(flightID);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return list;
	}

	@Override
	public List<Seat> findEmptySeatByFlightID(int flightID) throws Exception {
		// TODO Auto-generated method stub
				List<Seat> list = null;
				try {
					list = this.dao.findEmptySeatByFlightID(flightID);
				} catch (Exception e) {
					// TODO: handle exception
					throw e;
				}finally {
					this.dbconn.closeAll();
				}
				return list;
	}

}
