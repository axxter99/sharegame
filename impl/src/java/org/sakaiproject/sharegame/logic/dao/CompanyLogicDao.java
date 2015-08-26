package org.sakaiproject.sharegame.logic.dao;

import org.sakaiproject.user.api.ContextualUserDisplayService;
import org.sakaiproject.user.api.User;

import java.util.ArrayList;
import java.util.List;

import org.sakaiproject.sharegame.logic.CompanyLogic;
import org.sakaiproject.sharegame.model.Company;

public class CompanyLogicDao implements CompanyLogic, ContextualUserDisplayService {

	@Override
	public String getUserDisplayId(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserDisplayName(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserDisplayId(User user, String contextReference) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserDisplayName(User user, String contextReference) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> getCompany() {
		List<Company> c = new ArrayList<Company>();
		Company e = new Company();
		e.setCompanyCode("AGL");
		e.setCompanyName("Anglo American plc");
		e.setSector(1);

		c.add(e);
		
		return c;
	}

}
