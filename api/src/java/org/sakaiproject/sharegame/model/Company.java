package org.sakaiproject.sharegame.model;

/*
 * #%L
 * sharegame - API
 * %%
 * Copyright (C) 2003 - 2015 Sakai Project
 * %%
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *             http://opensource.org/licenses/ecl2
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.io.Serializable;

/**
 * @author dhorwitz
 *
 */
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
	private String website;
	
	public Company() {
		
	}
	public Company(long id, String companyCode, String companyName, String website) {
		this.id = id;
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.website = website;
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
	
	/**
	 * @return
	 */
	public Integer getSector() {
		return sector;
	}
	public void setSector(Integer sector) {
		this.sector = sector;
	}
	
	/**
	 * @return
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	
	
	
}
