package com.abs.model;

import java.io.Serializable;

public class Trip implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1557443873881663748L;
	
	private static int idCounter = 0;
	
	private int		id;
	private	int		flightInfoID;
	private	double	fare; 	// 不同于 FlightInfo中的fare，是折扣后的fare
	private	String	passport;
	private	int		seatID;
	
	public Trip() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlightInfoID() {
		return flightInfoID;
	}

	public void setFlightInfoID(int flightInfoID) {
		this.flightInfoID = flightInfoID;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public int getSeatID() {
		return seatID;
	}

	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}

	public static int getIdCounter() {
		return idCounter++;
	}
}
