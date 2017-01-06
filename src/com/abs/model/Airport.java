package com.abs.model;

import java.io.Serializable;

public class Airport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5845538001328360081L;
	
	private String	code;
	private	String	name;
	private	String	city;
	private	String	country;
	private	int		connTime;
	
	public Airport() {
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getConnTime() {
		return connTime;
	}

	public void setConnTime(int connTime) {
		this.connTime = connTime;
	}
}
