package com.abs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abs.action.OrderAction;
import com.abs.db.DBName;
import com.abs.factory.DaoFactory;
import com.abs.model.FlightInfo;
import com.abs.model.Orders;
import com.abs.model.Passenger;

public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String[] fIDList = request.getParameterValues("flightInfoID"); 
		String[] nameList = request.getParameterValues("name");
		String[] passportList = request.getParameterValues("passport");	
		String[] seatTypeList = new String[nameList.length];
		for(int i = 0; i < seatTypeList.length; i++){
			seatTypeList[i] = request.getParameter("seatType" + (i + 1)); System.out.println(seatTypeList[i]);
		}
		String contactName = request.getParameter("contact");
		String contactPhone	= request.getParameter("phone");
		
		List<FlightInfo> flightInfoList = new ArrayList<FlightInfo>();
		try {
			for (String idString : fIDList) { 
				FlightInfo flightInfo = DaoFactory.getFlightInfoDaoInstance(DBName.ABS).findByID(Integer.parseInt(idString));
				if(null != flightInfo){
					flightInfoList.add(flightInfo);
				}
			}
			//	discount of same airline
			if(flightInfoList.size() == 2){
				FlightInfo f1 = flightInfoList.get(0);
				FlightInfo f2 = flightInfoList.get(1);
				
				if(f1.getAirlineCode().equals(f2.getAirlineCode())){
					double discount = DaoFactory.getAirlineDaoInstance(DBName.ABS).findByCode(f1.getAirlineCode()).getDiscount();
					f2.setFare(f2.getFare() * discount); 
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Passenger> passengers = new ArrayList<Passenger>();
		for(int i = 0; i < nameList.length; i++){
			Passenger passenger = new Passenger();				System.out.println(i + " : " + nameList[i] + " " + passportList[i]);
			passenger.setName(nameList[i]);
			passenger.setPassport(passportList[i]);
			passengers.add(passenger);
		}
		
		Orders order = null;
		try {
			order = OrderAction.createOrder(flightInfoList, passengers, seatTypeList, contactName, contactPhone);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//	test only	--------
//		java.util.Date date = new java.util.Date();
//		Orders order = new Orders();
//		order.setId(1003021);
//		order.setCreateDate(new Date(date.getTime()));
//		order.setCreateTime(new Time(date.getTime()));
//		double sum = 0; 
//		for(FlightInfo flightInfo : flightInfoList){
//			sum += flightInfo.getFare();
//		}
//		order.setTotalFare(sum);
//		order.setContactName(contactName);
//		order.setContactPhone(contactPhone);
		// test only	--------
		
		request.setAttribute("flightInfoList", flightInfoList);	
		request.setAttribute("passengers", passengers);	
		request.setAttribute("order", order);	
		
		request.getRequestDispatcher("/generateOrder.jsp").forward(request,response);
	}
}
