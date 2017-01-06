package com.abs.model;

import java.io.Serializable;
import java.sql.*;

public class Orders implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7603388547114215304L;
	
	private static int idCounter = 100001;
	
	private	int		id;			//	id相同的为同一个订单
	private	int		tripID;
	private Date	createDate;
	private Time	createTime;
	private double 	totalFare;
	private String	contactName;
	private String 	contactPhone;
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTripID() {
		return tripID;
	}

	public void setTripID(int tripID) {
		this.tripID = tripID;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Time getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Time createTime) {
		this.createTime = createTime;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public static int getIdCounter() {
		return idCounter;
	}

	public static void addIdCounter() {
		Orders.idCounter++;
	}
}
