package com.abs.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abs.action.SearchAction;
import com.abs.model.FlightInfo;

public class SearchServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String departureCity = request.getParameter("departureCity");
		String arrivalCity	= request.getParameter("arrivalCity");
		String departureDate = request.getParameter("departureDate");
		//String returnDate = request.getParameter("returnDate");
		
		request.setAttribute("currentDepartureCity", departureCity);
		request.setAttribute("currentArrivalCity", arrivalCity);
		request.setAttribute("currentDepartureDate", departureDate);
		//request.setAttribute("currentReturnDate", returnDate);

		List<FlightInfo> list = null;
		List<List<FlightInfo>> transferList = null;

		//	directly flight
		try {
			list = SearchAction.searchFlightDirectly(departureCity, arrivalCity, departureDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(list.size() > 0){
			 Collections.sort(list,new Comparator<FlightInfo>(){

				@Override
				public int compare(FlightInfo o1, FlightInfo o2) {
					// TODO Auto-generated method stub
					return o1.getDepatureTime().compareTo(o2.getDepatureTime());
				}});
			
			request.setAttribute("list", list);
		}else {
			//	transfer flight
			try {
				transferList = SearchAction.searchFlightTransfer(departureCity, arrivalCity, departureDate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(transferList.size() > 0){
				Collections.sort(transferList,new Comparator<List<FlightInfo>>(){

					@Override
					public int compare(List<FlightInfo> o1, List<FlightInfo> o2) {
						// TODO Auto-generated method stub
						return o1.get(0).getDepatureTime().compareTo(o2.get(0).getDepatureTime());
					}});
				
				request.setAttribute("transferList", transferList);
			}else{
				//	显示没有结果
				request.setAttribute("noResult", "noResult");
			}
			
			// ******* test only ********  transfer path
			for (List<FlightInfo> list2 : transferList) {
				for (FlightInfo flightInfo : list2) {
					System.out.println(flightInfo.getDepatureAirportCity() + " " + flightInfo.getArrivalAirportCity());
				}
				System.out.println("***********************");
			}
		}
		
		request.getRequestDispatcher("/resultList.jsp").forward(request,response);
	}
}
