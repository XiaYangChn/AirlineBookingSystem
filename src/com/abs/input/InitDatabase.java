package com.abs.input;

import java.util.ArrayList;
import java.util.List;

import com.abs.db.DBName;
import com.abs.factory.DaoFactory;
import com.abs.model.Airline;
import com.abs.model.Airplane;
import com.abs.model.Airport;

public class InitDatabase {
	
	public static void initAirline() throws Exception {
		Airline airline = new Airline();
//		airline_1  MU(东方航空), airline_2  CZ(南方航空), airline_3  CA(中国国航) 
		airline.setCode("MU");
		airline.setName("东方航空");
		airline.setDiscount(0.9);
		DaoFactory.getAirlineDaoInstance(DBName.AIRLINE_1).add(airline);
		airline.setCode("CZ");
		airline.setName("南方航空");
		airline.setDiscount(0.95);
		DaoFactory.getAirlineDaoInstance(DBName.AIRLINE_2).add(airline);
		airline.setCode("CA");
		airline.setName("中国国航");
		airline.setDiscount(0.85);
		DaoFactory.getAirlineDaoInstance(DBName.AIRLINE_3).add(airline);
	}
	
	public static void initAirport() throws Exception {
		List<String[]> list = new ArrayList<String[]>();

		list.add(new String[]{"whs", "天河国际机场", "武汉"});
		list.add(new String[]{"shs", "浦东国际机场", "上海"});
		list.add(new String[]{"bjs", "首都国际机场", "北京"});
		list.add(new String[]{"szs", "深圳国际机场", "深圳"});
		list.add(new String[]{"gzs", "广州国际机场", "广州"});
		list.add(new String[]{"cds", "成都国际机场", "成都"});
		list.add(new String[]{"sys", "沈阳国际机场", "沈阳"});
		list.add(new String[]{"xzs", "西藏国际机场", "西藏"});
		
		for (String[] str : list) {
			Airport airport = new Airport();
			airport.setCode(str[0]);
			airport.setName(str[1]);
			airport.setCity(str[2]);
			airport.setCountry("中国");
			airport.setConnTime(60);
			DaoFactory.getAirportDaoInstance(DBName.ABS).add(airport);
			DaoFactory.getAirportDaoInstance(DBName.AIRLINE_1).add(airport);
			DaoFactory.getAirportDaoInstance(DBName.AIRLINE_2).add(airport);
			DaoFactory.getAirportDaoInstance(DBName.AIRLINE_3).add(airport);
		}
	}
	
	public static void initAirplane() throws Exception {
		List<String[]> list = new ArrayList<String[]>();
		
		list.add(new String[]{"空客A380", "大"});
		list.add(new String[]{"波音747", "大"});
		list.add(new String[]{"空客A320", "中"});
		list.add(new String[]{"波音737", "中"});	
		
		for (String[] str : list) {
			Airplane airplane = new Airplane();
			airplane.setName(str[0]);
			airplane.setType(str[1]);	
			
			DaoFactory.getAirplaneDaoInstance(DBName.AIRLINE_1).add(airplane);
			DaoFactory.getAirplaneDaoInstance(DBName.AIRLINE_2).add(airplane);
			DaoFactory.getAirplaneDaoInstance(DBName.AIRLINE_3).add(airplane);
		}
	}
	
	public static void init() throws Exception {
			//	初始化航空公司信息
			initAirline();
			//	初始化机场信息
			initAirport();
			//	初始化飞机信息
			initAirplane();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		init();
	}
}
