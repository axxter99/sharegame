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

import uk.org.ponder.rsf.components.UIBranchContainer;
import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.components.UIInternalLink;
import uk.org.ponder.rsf.components.UIOutput;
import uk.org.ponder.rsf.view.ComponentChecker;
import uk.org.ponder.rsf.view.ViewComponentProducer;
import uk.org.ponder.rsf.viewstate.SimpleViewParameters;
import uk.org.ponder.rsf.viewstate.ViewParameters;

public class CompanyInfo implements ViewComponentProducer {

	private static Log log = LogFactory.getLog(CompanyInfo.class);
	public static final String VIEW_ID = "companyinfo";

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
		log.info("CompanyInfo!");
		// Select * from companies,sector where companies.sector=sector.sectorid
		// and used order by companyname");
		// for ($i=0;$i<pg_numrows($arecordset);$i++) {
		// <a href="companies2.php?code="><!--
		// ?=pg_result($arecordset,$i,"companycode")? --><!--
		// ?=pg_result($arecordset,$i,"companyname")? --></a>
		// <!-- ?=pg_result($arecordset,$i,"companycode")? -->
		// <!-- ?=pg_result($arecordset,$i,"sectorname")? -->
		// }

		navBarRenderer.makeNavBar(tofill, "navIntraTool:", VIEW_ID); 
		List<Company> c = companyLogic.getCompany();

		log.info("c: " + c.size()); 

		for (int i = 0; i < c.size(); i++) {

			Company q = c.get(i);
			log.info("q: " + i);
			log.info(q.getCompanyCode() + ": " + q.getCompanyName());
			UIBranchContainer row = UIBranchContainer.make(tofill, "thCM:");
			UIInternalLink.make(row, "companyCode", q.getCompanyCode(), new SimpleViewParameters(Companies2.VIEW_ID));
			UIOutput.make(row, "companyName", q.getCompanyName());

			UIOutput.make(row, "sectorName", q.getSector().toString()); 

		} 
		log.info("lesh");

	}

	@Override
	public String getViewID() {
		return VIEW_ID;
	}

}
