package com.abs.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abs.db.DBName;
import com.abs.factory.DaoFactory;
import com.abs.model.FlightInfo;

public class BookingServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String[] fIDList = request.getParameterValues("flightInfoID");
		
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
		request.setAttribute("flightInfoList", flightInfoList);	
		
		request.getRequestDispatcher("/booking.jsp").forward(request,response);
	}

}
