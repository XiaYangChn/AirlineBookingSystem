package com.abs.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.abs.dao.FlightInfoDao;
import com.abs.dao.impl.FlightInfoDaoImpl;
import com.abs.db.DBConnection;
import com.abs.db.DBName;
import com.abs.model.FlightInfo;

public class FlightInfoService implements FlightInfoDao {
	
	private DBConnection dbconn = null;
	private FlightInfoDao dao = null;
	
	public FlightInfoService(DBName dbName) throws Exception {
		// TODO Auto-generated constructor stub
		this.dbconn = new DBConnection();
		this.dao = new FlightInfoDaoImpl(dbconn.getConnection(dbName));
	}

	@Override
	public boolean add(FlightInfo flightInfo) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.add(flightInfo);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return flag;
	}

	@Override
	public FlightInfo findByID(int id) throws Exception {
		// TODO Auto-generated method stub
		FlightInfo flightInfo = null;
		try {
			flightInfo = this.dao.findByID(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return flightInfo;
	}

	@Override
	public List<FlightInfo> findByAirport(String depatureAirportCity, String arrivalAirportCity, Date depatureDate) throws Exception {
		// TODO Auto-generated method stub
		List<FlightInfo> list = null;
		try {
			list = this.dao.findByAirport(depatureAirportCity, arrivalAirportCity, depatureDate);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return list;
	}

	@Override
	public List<FlightInfo> findByDepatureAirport(String depatureAirportCity, Date depatureDate) throws Exception {
		// TODO Auto-generated method stub
		List<FlightInfo> list = null;
		try {
			list = this.dao.findByDepatureAirport(depatureAirportCity, depatureDate);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return list;
	}

	@Override
	public List<FlightInfo> findByTransferArrivalAirport(String depatureAirportCity, String arrivalAirportCity, Date depatureDate, Time depatureTime) throws Exception {
		// TODO Auto-generated method stub
		List<FlightInfo> list = null;
		try {
			list = this.dao.findByTransferArrivalAirport(depatureAirportCity, arrivalAirportCity, depatureDate,depatureTime);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return list;
	}

	@Override
	public int addPassenger(int id) throws Exception {
		// TODO Auto-generated method stub
		int emptySeats = -1;
		try {
			emptySeats = this.dao.addPassenger(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return emptySeats;
	}

}
