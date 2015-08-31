package org.sakaiproject.sharegame.tool.producers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.view.ComponentChecker;
import uk.org.ponder.rsf.view.ViewComponentProducer;
import uk.org.ponder.rsf.viewstate.ViewParameters;

public class Companies2 implements ViewComponentProducer {
	
	private static Log log = LogFactory.getLog(Companies2.class);
	
	public static final String VIEW_ID = "companies2";
	
	@Override
	public void fillComponents(UIContainer tofill, ViewParameters viewparams, ComponentChecker checker) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getViewID() {
		
		return VIEW_ID;
	}

}
