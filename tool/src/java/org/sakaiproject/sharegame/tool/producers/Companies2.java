package org.sakaiproject.sharegame.tool.producers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.sharegame.logic.CompanyLogic;
import org.sakaiproject.sharegame.model.Company;

import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.components.UIInternalLink;
import uk.org.ponder.rsf.components.UIOutput;
import uk.org.ponder.rsf.view.ComponentChecker;
import uk.org.ponder.rsf.view.ViewComponentProducer;
import uk.org.ponder.rsf.viewstate.SimpleViewParameters;
import uk.org.ponder.rsf.viewstate.ViewParameters;

public class Companies2 implements ViewComponentProducer {
	
	private static Log log = LogFactory.getLog(Companies2.class);
	
	public static final String VIEW_ID = "companies2";
	
	private CompanyLogic companyLogic;

	public void setCompanyLogic(CompanyLogic companyLogic) {
		this.companyLogic = companyLogic;
	}
	
	@Override
	public void fillComponents(UIContainer tofill, ViewParameters viewparams, ComponentChecker checker) {
		// TODO Auto-generated method stub
		List<Company> c = companyLogic.getCompany();
		Company q = c.get(1);
		
		UIOutput.make(tofill, "companyCode", q.getCompanyCode()); 
		UIOutput.make(tofill, "companyName", q.getCompanyName());
		
		try {
			UIOutput.make(tofill, "sectorName", q.getSector().toString());
		} catch (NullPointerException e) {
			log.error(e.fillInStackTrace());
		}
		
	}

	@Override
	public String getViewID() {
		
		return VIEW_ID;
	}

}
