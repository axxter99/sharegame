package org.sakaiproject.sharegame.tool.producers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.sharegame.model.Company;

import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.view.ComponentChecker;
import uk.org.ponder.rsf.view.ViewComponentProducer;
import uk.org.ponder.rsf.viewstate.ViewParameters;

public class CompanyInfo implements ViewComponentProducer {
	
	private static Log log = LogFactory.getLog(CompanyInfo.class);
	public static final String VIEW_ID = "companyinfo";
	@Override
	public void fillComponents(UIContainer tofill, ViewParameters viewparams, ComponentChecker checker) {
		log.info("CompanyInfo!");
		//Select * from companies,sector where companies.sector=sector.sectorid and used order by companyname");
		 //for ($i=0;$i<pg_numrows($arecordset);$i++) {
		   //<a href="companies2.php?code="><!-- ?=pg_result($arecordset,$i,"companycode")? --><!-- ?=pg_result($arecordset,$i,"companyname")? --></a>
			//<!-- ?=pg_result($arecordset,$i,"companycode")? -->
			//<!-- ?=pg_result($arecordset,$i,"sectorname")? -->
		//}
		
		List<Company> c = new ArrayList<Company>();
		Company e = new Company();
		
				
		c.add(e);


		log.info("c: " + c.size());
		for (int i = 1; i <= c.size(); i++ ) {
			log.info("for!");
		}

	}

	@Override
	public String getViewID() {
		return VIEW_ID;
	}

}
