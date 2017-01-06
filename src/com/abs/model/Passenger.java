package com.abs.model;

import java.io.Serializable;

public class Passenger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -732779128372545241L;
	
	private	String	passport;
	private	String	name;
	
	
	public Passenger() {
		// TODO Auto-generated constructor stub
	}


	public String getPassport() {
		return passport;
	}


	public void setPassport(String passport) {
		this.passport = passport;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
