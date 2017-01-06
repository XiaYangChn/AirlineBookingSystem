package com.abs.model;

import java.io.Serializable;
import java.sql.*;

public class FlightInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1120691064949561201L;
	
	private int		id;
	private	String	airlineCode;
	private	int		flightID;
	
	private	int		number;
	private Date	depatureDate;
	private Time 	depatureTime;
	private Date	arrivalDate;
	private Time	arrivalTime;
	private	double	fare;
	private	String	depatureAirport;
	private	String	arrivalAirport;
	
	private String	airlineName;
	private	String	airplaneName;
	private String	airplaneType;
	private	String	depatureAirportName;
	private	String	arrivalAirportName;
	private	String	depatureAirportCity;
	private	String	arrivalAirportCity;
	
	private	int		airplaneEmptySeats;
	
	public FlightInfo() {
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

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
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

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
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

	public String getDepatureAirportName() {
		return depatureAirportName;
	}

	public void setDepatureAirportName(String depatureAirportName) {
		this.depatureAirportName = depatureAirportName;
	}

	public void setDepatureAirportCity(String depatureAirportCity) {
		this.depatureAirportCity = depatureAirportCity;
	}

	public String getArrivalAirportCity() {
		return arrivalAirportCity;
	}

	public String getArrivalAirportName() {
		return arrivalAirportName;
	}

	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}

	public String getDepatureAirportCity() {
		return depatureAirportCity;
	}

	public void setArrivalAirportCity(String arrivalAirportCity) {
		this.arrivalAirportCity = arrivalAirportCity;
	}
	
	public int getAirplaneEmptySeats() {
		return airplaneEmptySeats;
	}

	public void setAirplaneEmptySeats(int airplaneEmptySeats) {
		this.airplaneEmptySeats = airplaneEmptySeats;
	}
}
