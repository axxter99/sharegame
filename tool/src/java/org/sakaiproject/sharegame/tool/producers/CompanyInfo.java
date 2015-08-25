package org.sakaiproject.sharegame.tool.producers;

import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.view.ComponentChecker;
import uk.org.ponder.rsf.view.ViewComponentProducer;
import uk.org.ponder.rsf.viewstate.ViewParameters;

public class CompanyInfo implements ViewComponentProducer {
	public static final String VIEW_ID = "companyinfo";
	@Override
	public void fillComponents(UIContainer tofill, ViewParameters viewparams, ComponentChecker checker) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getViewID() {
		return VIEW_ID;
	}

}
