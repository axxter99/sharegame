package org.sakaiproject.sharegame.tool.producers;

/*
 * #%L
 * sharegame - Tool
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

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.sharegame.logic.CompanyLogic;
import org.sakaiproject.sharegame.model.Company;
import org.sakaiproject.sharegame.tool.renderers.NavBarRenderer;

import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.components.UIInternalLink;
import uk.org.ponder.rsf.components.UILink;
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
	
	private NavBarRenderer navBarRenderer;
	public void setNavBarRenderer(NavBarRenderer navBarRenderer) {
		this.navBarRenderer = navBarRenderer;
	}
	
	@Override
	public void fillComponents(UIContainer tofill, ViewParameters viewparams, ComponentChecker checker) {
		// TODO Auto-generated method stub
		List<Company> c = companyLogic.getCompany();
		Company q = c.get(1);
		navBarRenderer.makeNavBar(tofill, "navIntraTool:", VIEW_ID); 
		
		UIOutput.make(tofill, "companyCode", q.getCompanyCode()); 
		UIOutput.make(tofill, "companyName", q.getCompanyName());
		//UIInternalLink.make(tofill, "website", q.getWebsite, viewparams);
		UILink.make(tofill, "website", q.getWebsite(), q.getWebsite());
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
