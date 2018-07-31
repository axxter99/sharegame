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
import java.time.Instant;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Bank Accounts User
 * @author dhorwitz
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountsUser implements Serializable {
/**CREATE TABLE bankaccounts (
    mid character varying(10) NOT NULL,
    balance numeric(20,4) DEFAULT 0 NOT NULL
);
**/
	public BankAccountsUser(String user) {
		this.user = user;
	}
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String user;
	
	private Double balance;
	
	private long site;
	private Instant creationDate;
	private Instant modefiedOn;

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

	public Instant getModefiedOn() {
		return modefiedOn;
	}

	public void setModefiedOn(Instant modefiedOn) {
		this.modefiedOn = modefiedOn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public long getSite() {
		return site;
	}

	public void setSite(long site) {
		this.site = site;
	}
	
	
}
