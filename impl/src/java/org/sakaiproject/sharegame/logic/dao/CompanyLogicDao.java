package org.sakaiproject.sharegame.logic.dao;

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
