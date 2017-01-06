package com.abs.model;

import java.io.Serializable;
import java.sql.*;

public class Flight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7628610524869432675L;

	private static int idCounter = 0;
	
	private	int		id;
	private	String	airlineCode;
	private	int		number;
	private Date	depatureDate;
	private Time 	depatureTime;
	private Date	arrivalDate;
	private Time	arrivalTime;
	private	double	fare;
	private	String	depatureAirport;
	private	String	arrivalAirport;
	private	String	airplaneName;
	private String	airplaneType;

	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(Date depatureDate) {
		this.depatureDate = depatureDate;
	}

	public Time getDepatureTime() {
		return depatureTime;
	}

	public void setDepatureTime(Time depatureTime) {
		this.depatureTime = depatureTime;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getDepatureAirport() {
		return depatureAirport;
	}

	public void setDepatureAirport(String depatureAirport) {
		this.depatureAirport = depatureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	
	public String getAirplaneName() {
		return airplaneName;
	}

	public void setAirplaneName(String airplaneName) {
		this.airplaneName = airplaneName;
	}

	public String getAirplaneType() {
		return airplaneType;
	}

	public void setAirplaneType(String airplaneType) {
		this.airplaneType = airplaneType;
	}

	public static int getIdCounter() {
		return idCounter++;
	}
}
