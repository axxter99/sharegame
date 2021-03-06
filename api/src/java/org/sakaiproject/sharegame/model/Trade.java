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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author dhorwitz
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="SHAREGAME_TRADE")
public class Trade implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TRADE_ID", nullable = false)
	private long id;
	
	@Column(name = "SYMBOL")
	private String symbol;
	
	@Column(name = "COMPANY")
	private String company;
	
	@Column(name = "DATE")
	@Type(type = "org.sakaiproject.springframework.orm.hibernate.type.Date")
    private Date date;
	
	@Column(name = "INSTANT")
    @Type(type = "org.sakaiproject.springframework.orm.hibernate.type.InstantType")
    private Instant instant;

	@Override
	public String toString() {
		return "Trade [id=" + id + ", symbol=" + symbol + ", company=" + company + ", date=" + date + ", instant="
				+ instant + "]";
	}
	
}
