package com.abs.model;

import java.io.Serializable;

public class Airline implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3621368593456284939L;
	
	private String	code;
	private	String	name;
	private double	discount;
	
	public Airline() {
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
