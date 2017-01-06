package com.abs.model;

import java.io.Serializable;

public class Airplane implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8334803167727479411L;

	private	String	name;
	private	String	type;
	
	public Airplane() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
