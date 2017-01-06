package com.abs.action;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.abs.db.DBName;
import com.abs.factory.DaoFactory;
import com.abs.model.Flight;
import com.abs.model.FlightInfo;
import com.abs.model.Orders;
import com.abs.model.Passenger;
import com.abs.model.Seat;
import com.abs.model.Trip;

public class OrderAction {

	public static Orders createOrder(List<FlightInfo> flightInfos, List<Passenger> passengers, String[] seatTypeList, String contactName, String contactPhone) throws Exception {
		//	生成订单编号
		Orders.addIdCounter();
		
		Orders order = null;
		double total = 0;
		
		for (FlightInfo flightInfo : flightInfos) {
			total += flightInfo.getFare();
		}
		total = total * passengers.size();		//	计算总费用
		
		for (Passenger passenger : passengers) {
			DaoFactory.getPassengerDaoInstance(DBName.ABS).add(passenger);
		}
		
		for (FlightInfo flightInfo : flightInfos) {
			for (Passenger passenger : passengers) {
				Trip trip = new Trip();
				trip.setId(Trip.getIdCounter());
				trip.setFlightInfoID(flightInfo.getId());
				trip.setFare(flightInfo.getFare());
				trip.setPassport(passenger.getPassport());
				trip.setSeatID(OrderAction.orderSeat(flightInfo, passenger, seatTypeList[passengers.indexOf(passenger)]));	//	分配座位
				flightInfo.setAirplaneEmptySeats(flightInfo.getAirplaneEmptySeats() - 1); 		//	空闲座位数 - 1
				DaoFactory.getFlightInfoDaoInstance(DBName.ABS).addPassenger(flightInfo.getId());	//	空闲座位数 - 1
				DaoFactory.getTripDaoInstance(DBName.ABS).add(trip);
				
				Orders orders = new Orders();
				orders.setId(Orders.getIdCounter());	//	同一个订单号，代表为同一个订单
				orders.setTripID(trip.getId()); 		//	每个Orders item 与一个 Trip 一一对应
				java.util.Date date = new java.util.Date();
				orders.setCreateDate(new Date(date.getTime()));
				orders.setCreateTime(new Time(date.getTime()));
				orders.setTotalFare(total);
				orders.setContactName(contactName);
				orders.setContactPhone(contactPhone);
				DaoFactory.getOrdersDaoInstance(DBName.ABS).add(orders);
				
				order = orders;		//	返回一个 Orders item用于显示
			}
		}
		
		return order;
	}
	
	public static int orderSeat(FlightInfo flightInfo, Passenger passenger, String seatType) throws Exception {
		int seatID = -1;
		
		String airlineCode = flightInfo.getAirlineCode();
		Flight flight = null;	
		//	airline_1  MU(东方航空), airline_2  CZ(南方航空), airline_3  CA(中国国航) 
		if(airlineCode.equals("MU")){			//	airline_1  MU(东方航空)
			flight = DaoFactory.getFlightDaoInstance(DBName.AIRLINE_1).findByID(flightInfo.getFlightID()); 
			List<Seat> emptySeats = DaoFactory.getSeatDaoInstance(DBName.AIRLINE_1).findEmptySeatByFlightID(flight.getId());
			
			if (emptySeats.size() > 0) {
				Seat seat = null;
				for (Seat emptySeat : emptySeats) {
					if(emptySeat.getType() == seatType){
						seat = emptySeat;
						break;
					}
				}
				if(seat == null){
					seat = emptySeats.get(0);
				}
				
				seat.setPassport(passenger.getPassport());
				DaoFactory.getSeatDaoInstance(DBName.AIRLINE_1).modify(seat);
				
				seatID = seat.getRelativeID();
			}
		}else if (airlineCode.equals("CZ")) {	//	airline_2  CZ(南方航空)
			flight = DaoFactory.getFlightDaoInstance(DBName.AIRLINE_2).findByID(flightInfo.getFlightID()); 
			List<Seat> emptySeats = DaoFactory.getSeatDaoInstance(DBName.AIRLINE_2).findEmptySeatByFlightID(flight.getId());
			
			if (emptySeats.size() > 0) {
				Seat seat = null;
				for (Seat emptySeat : emptySeats) {
					if(emptySeat.getType() == seatType){
						seat = emptySeat;
					}
				}
				if(seat == null){
					seat = emptySeats.get(0);
				}
				
				seat.setPassport(passenger.getPassport());
				DaoFactory.getSeatDaoInstance(DBName.AIRLINE_2).modify(seat);

				seatID = seat.getRelativeID();
			}
		}else {								//	airline_3  CA(中国国航) 
			flight = DaoFactory.getFlightDaoInstance(DBName.AIRLINE_3).findByID(flightInfo.getFlightID()); 
			List<Seat> emptySeats = DaoFactory.getSeatDaoInstance(DBName.AIRLINE_3).findEmptySeatByFlightID(flight.getId());
			
			if (emptySeats.size() > 0) {
				Seat seat = null;
				for (Seat emptySeat : emptySeats) {
					if(emptySeat.getType() == seatType){
						seat = emptySeat;
					}
				}
				if(seat == null){
					seat = emptySeats.get(0);
				}
				
				seat.setPassport(passenger.getPassport());
				DaoFactory.getSeatDaoInstance(DBName.AIRLINE_3).modify(seat);

				seatID = seat.getRelativeID();
			}
		}
		
		return seatID;
	}
}
