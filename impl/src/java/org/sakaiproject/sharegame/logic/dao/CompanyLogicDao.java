package org.sakaiproject.sharegame.logic.dao;

/*
 * #%L
 * sharegame - Implementation
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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.sharegame.logic.CompanyLogic;
import org.sakaiproject.sharegame.model.Company;

public class CompanyLogicDao implements CompanyLogic {

	private static Log log = LogFactory.getLog(CompanyLogicDao.class);
	public void init(){
		log.info("init()");
	}

	@Override
	public List<Company> getCompany() {
		List<Company> c = new ArrayList<Company>();
		Company e = new Company();
		e.setCompanyCode("AGL");
		e.setId(1);
		e.setCompanyName("Anglo American plc");
		e.setWebsite("http://www.angloamerican.com/");
		e.setSector(1);

		c.add(e);
		Company f = new Company(2, "BCE", "and sdfgsd", "htp:www.sdsf.com");
		f.setSector(1);
		c.add(f);
		return c;
	}

}
