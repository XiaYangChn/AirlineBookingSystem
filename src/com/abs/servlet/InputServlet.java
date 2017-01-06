package com.abs.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abs.input.AddFlight;
import com.abs.model.Flight;

public class InputServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String departureDate = request.getParameter("depatureDate");
		String departureTime = request.getParameter("depatureTime") + ":00";
		String arrivalDate = request.getParameter("arrivalDate");
		String arrivalTime = request.getParameter("arrivalTime") + ":00";
		String departureAirport = request.getParameter("depatureAirportCode");
		String arrivalAirport = request.getParameter("arrivalAirportCode");
		String airplaneName = request.getParameter("airplaneName");
		int airline = Integer.parseInt(request.getParameter("airline"));
		int	number = Integer.parseInt(request.getParameter("number"));
		double fare = Double.parseDouble(request.getParameter("fare"));
		
		Map<String,String> map=new HashMap<String,String>(); 
		map.put("空客A380", "大");
		map.put("空客A320", "中");
		map.put("波音747", "大");
		map.put("波音737", "中");
		
		Flight flight = new Flight();
		flight.setId(Flight.getIdCounter());
											
		flight.setDepatureDate(Date.valueOf(departureDate));
		flight.setDepatureTime(Time.valueOf(departureTime));
		flight.setArrivalDate(Date.valueOf(arrivalDate));
		flight.setArrivalTime(Time.valueOf(arrivalTime));
		flight.setDepatureAirport(departureAirport);
		flight.setArrivalAirport(arrivalAirport);
		flight.setAirplaneName(airplaneName);
		flight.setAirplaneType(map.get(airplaneName));
		flight.setNumber(number);
		flight.setFare(fare);
		
		try {
			AddFlight.addFlight(flight, airline);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/io.jsp").forward(request,response);
	}

}
