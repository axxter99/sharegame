package org.sakaiproject.sharegame.logic.dao;

import java.util.ArrayList;
import java.util.List;

import org.sakaiproject.sharegame.logic.CompanyLogic;
import org.sakaiproject.sharegame.model.Company;

public class CompanyLogicDao implements CompanyLogic {




	@Override
	public List<Company> getCompany() {
		List<Company> c = new ArrayList<Company>();
		Company e = new Company();
		e.setCompanyCode("AGL");
		e.setCompanyName("Anglo American plc");
		e.setSector(1);

		c.add(e);
		Company f = new Company(2, "BCE", "and sdfgsd");
		c.add(f);
		return c;
	}

}
