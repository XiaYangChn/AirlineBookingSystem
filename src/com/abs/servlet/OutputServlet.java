package com.abs.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abs.db.DBName;
import com.abs.factory.DaoFactory;
import com.abs.model.Orders;

public class OutputServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		List<Orders> resultList = null;
		try {
			resultList = DaoFactory.getOrdersDaoInstance(DBName.ABS).findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Orders> list = new ArrayList<Orders>();
		if(resultList.size() > 0);{
			int flag = -1;
			for (int i = resultList.size() - 1; i >= 0 ; i--) {
				Orders orders = resultList.get(i);
				if(orders.getId() != flag){
					list.add(orders);
					flag = orders.getId();
				}
			}
		}
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/io.jsp").forward(request,response);
	}

}
