package org.sakaiproject.sharegame.model;

import java.io.Serializable;

public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String symbol;
	private String company;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
