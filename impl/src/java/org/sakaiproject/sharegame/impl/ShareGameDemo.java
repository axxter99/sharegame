package org.sakaiproject.sharegame.impl;

import java.util.ArrayList;
import java.util.List;

import org.sakaiproject.sharegame.logic.CompanyLogic;
import org.sakaiproject.sharegame.model.Company;
import org.sakaiproject.sharegame.model.Sector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShareGameDemo {

	private static Logger log = LoggerFactory.getLogger(ShareGameDemo.class);
	
	private CompanyLogic companyLogic;
	
	public void setCompanyLogic(CompanyLogic companyLogic) {
		this.companyLogic = companyLogic;
	}

	public void init()
	{
		
		log.info("init()");
		addCompy();
		
	}
	
	private void addCompy() {
		
		//Mining
		Sector s = new Sector();
		s.setSector("Mining");
		companyLogic.sectorSave(s);
		
		
		Company e = new Company();
		e.setCompanyCode("AGL");
		e.setId(1);
		e.setCompanyName("Anglo American plc");
		e.setWebsite("http://www.angloamerican.com/");
		e.setSector(s);
		
		Company f = new Company(2, "BCE", "and sdfgsd", "htp:www.sdsf.com");
		f.setSector(s);
		
		
		
		companyLogic.save(e);
		companyLogic.save(f);
		
		//Technology 
		Sector t = new Sector();
		t.setSector("Technology");
		companyLogic.sectorSave(t);
		
		Company apple = new Company();
		apple.setCompanyCode("AAPL");
		apple.setCompanyName("Apple Inc.");
		apple.setWebsite("apple.com");
		apple.setSector(t);
		companyLogic.save(apple);
		
		
	}
}
