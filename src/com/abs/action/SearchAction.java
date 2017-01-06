package com.abs.action;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import com.abs.db.DBName;
import com.abs.factory.DaoFactory;
import com.abs.model.*;

public class SearchAction {
	
	public static List<FlightInfo> searchFlightDirectly(String departureCity, String arrivalCity, String departureDateString) throws Exception {
		List<FlightInfo> list = null;
		
		Date departureDate = null;
		if (checkDate(departureDateString)) {	//	测试Date格式是否合格
			departureDate = Date.valueOf(departureDateString);
		}
		
		list = DaoFactory.getFlightInfoDaoInstance(DBName.ABS).findByAirport(departureCity, arrivalCity, departureDate);
		
		return list;
	}
	
	public static List<List<FlightInfo>> searchFlightTransfer(String departureCity, String arrivalCity, String departureDateString) throws Exception {
		List<List<FlightInfo>> list = new ArrayList<List<FlightInfo>>();
		
		Date departureDate = null;
		if (checkDate(departureDateString)) {	//	测试Date格式是否合格
			departureDate = Date.valueOf(departureDateString);
		}
		
		List<FlightInfo> departureList = DaoFactory.getFlightInfoDaoInstance(DBName.ABS).findByDepatureAirport(departureCity, departureDate);
		
		for (FlightInfo depatureFlight : departureList) {
			Airport transferAirport = DaoFactory.getAirportDaoInstance(DBName.ABS).findByCode(depatureFlight.getArrivalAirport());
			
			if(null != transferAirport){
				int connTime = transferAirport.getConnTime();	
				Time depatureTime = new Time(depatureFlight.getArrivalTime().getTime() + connTime * 60 * 1000);
				String transferCity = depatureFlight.getArrivalAirportCity();
				
				List<FlightInfo> arrivalList = DaoFactory.getFlightInfoDaoInstance(DBName.ABS).findByTransferArrivalAirport(transferCity, arrivalCity, departureDate, depatureTime);
				
				for (FlightInfo arrivalFlight : arrivalList) {
					List<FlightInfo> item = new ArrayList<FlightInfo>();
					if(depatureFlight.getAirlineCode().equals(arrivalFlight.getAirlineCode())){
						double discount = DaoFactory.getAirlineDaoInstance(DBName.ABS).findByCode(depatureFlight.getAirlineCode()).getDiscount();
						arrivalFlight.setFare(arrivalFlight.getFare() * discount); 
					}
					
					item.add(depatureFlight);
					item.add(arrivalFlight);
					list.add(item);
				}
			}else {
				System.err.println(depatureFlight.getArrivalAirportCity() + depatureFlight.getArrivalAirport() + ":没有找到机场信息");
			}
		}
		
		return list;
	}
	
	public static boolean checkDate(String date) {
		String regex= "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";   
        return Pattern.compile(regex).matcher(date).matches(); 
	}
}
