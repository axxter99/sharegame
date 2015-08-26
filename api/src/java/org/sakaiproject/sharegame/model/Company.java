package org.sakaiproject.sharegame.model;

import java.io.Serializable;

/**
 * @author dhorwitz
 *
 */
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * CREATE TABLE companies (
    cid integer DEFAULT nextval('companies_cid_seq'::text) NOT NULL,
    companyname character varying(50),
    exchangename character varying(50),
    companycode character varying(50),
    website text,
    used boolean,
    quickname character varying(255),
    sector character varying(50),
    active boolean,
    sharesissued integer,
    natureofbusiness text,
    nextresults text
);
	 */
	private long id;
	private String companyCode;
	private String companyName;
	private Integer sector;
	
	public Company() {
		
	}
	public Company(long id, String companyCode, String companyName) {
		this.id = id;
		this.companyCode = companyCode;
		this.companyName = companyName;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getSector() {
		return sector;
	}
	public void setSector(Integer sector) {
		this.sector = sector;
	}
	
	
	
}
