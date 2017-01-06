package com.abs.model;

import java.io.Serializable;

public class Seat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8544028025352855151L;
	
	private	int		id;
	private int		relativeID;
	private	int		row;
	private int		num;
	private String 	type;
	private	int		flightID;
	private	String	passport;
	
	public Seat() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRelativeID() {
		return relativeID;
	}

	public void setRelativeID(int relativeID) {
		this.relativeID = relativeID;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}
}
