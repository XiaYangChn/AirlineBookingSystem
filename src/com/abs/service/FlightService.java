package com.abs.service;

import java.util.List;

import com.abs.dao.FlightDao;
import com.abs.dao.FlightInfoDao;
import com.abs.dao.impl.FlightDaoImpl;
import com.abs.dao.impl.FlightInfoDaoImpl;
import com.abs.db.DBConnection;
import com.abs.db.DBName;
import com.abs.factory.DaoFactory;
import com.abs.model.Airport;
import com.abs.model.Flight;
import com.abs.model.FlightInfo;
import com.abs.model.Seat;

public class FlightService implements FlightDao {
	
	private DBConnection dbconn = null;
	private FlightDao 	dao = null;
	private FlightInfoDao	infoDao = null;
	private DBName dbName = null;
	
	public FlightService(DBName dbName) throws Exception {
		// TODO Auto-generated constructor stub
		this.dbconn = new DBConnection();
		this.dao = new FlightDaoImpl(dbconn.getConnection(dbName));
		this.infoDao = new FlightInfoDaoImpl(dbconn.getConnection(DBName.ABS));
		this.dbName = dbName;
	}

	@Override
	public boolean add(Flight flight) throws Exception {
		// TODO Auto-generated method stub
		boolean flag1 = false;
		boolean flag2 = false;
		try {
			flag1 = this.dao.add(flight);
			
			//	add seats
			String airplaneType = flight.getAirplaneType();
			int seatNum = 0;
			if(airplaneType == "大"){
				seatNum = 240;
			}else if (airplaneType == "中") {
				seatNum = 160;
			}else {
				seatNum = 80;
			}
			for(int i = 0; i < seatNum; i++){
				Seat seat = new Seat();
				seat.setRelativeID(i + 1);
				seat.setRow(i / 8 + 1);
				seat.setNum(i % 8 + 1);
				if(seat.getNum() == 1 || seat.getNum() == 8){
					seat.setType("windowSeat");
				}else if (seat.getNum() == 4 || seat.getNum() == 5) {
					seat.setType("aisleSeat");
				}else {
					seat.setType("middleSeat");
				}
				seat.setFlightID(flight.getId());
				DaoFactory.getSeatDaoInstance(dbName).add(seat);
			}
			
			//	add flightInfo
			FlightInfo flightInfo = new FlightInfo();
			flightInfo.setAirlineCode(flight.getAirlineCode());
			flightInfo.setFlightID(flight.getId());
			flightInfo.setNumber(flight.getNumber());
			flightInfo.setDepatureDate(flight.getDepatureDate());
			flightInfo.setDepatureTime(flight.getDepatureTime());
			flightInfo.setArrivalDate(flight.getArrivalDate());
			flightInfo.setArrivalTime(flight.getArrivalTime());
			flightInfo.setFare(flight.getFare());
			flightInfo.setDepatureAirport(flight.getDepatureAirport());
			flightInfo.setArrivalAirport(flight.getArrivalAirport());
			flightInfo.setAirlineName(DaoFactory.getAirlineDaoInstance(DBName.ABS).findByCode(flight.getAirlineCode()).getName());
			flightInfo.setAirplaneName(flight.getAirplaneName());
			flightInfo.setAirplaneType(flight.getAirplaneType());
			Airport departureAirport = DaoFactory.getAirportDaoInstance(dbName).findByCode(flight.getDepatureAirport());
			Airport arrivalAirport	= DaoFactory.getAirportDaoInstance(dbName).findByCode(flight.getArrivalAirport());
			flightInfo.setDepatureAirportName(departureAirport.getName());
			flightInfo.setArrivalAirportName(arrivalAirport.getName());
			flightInfo.setDepatureAirportCity(departureAirport.getCity());	
			flightInfo.setArrivalAirportCity(arrivalAirport.getCity());
			flightInfo.setAirplaneEmptySeats(seatNum);
			
			flag2 = infoDao.add(flightInfo);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return (flag1 && flag2);
	}

	@Override
	public Flight findByID(int id) throws Exception {
		// TODO Auto-generated method stub
		Flight flight = null;
		try {
			flight = this.dao.findByID(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			this.dbconn.closeAll();
		}
		return flight;
	}

	@Override
	public List<Flight> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Flight> list = null;
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
