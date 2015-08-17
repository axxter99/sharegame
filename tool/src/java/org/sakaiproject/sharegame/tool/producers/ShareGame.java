package org.sakaiproject.sharegame.tool.producers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.view.ComponentChecker;
import uk.org.ponder.rsf.view.DefaultView;
import uk.org.ponder.rsf.view.ViewComponentProducer;
import uk.org.ponder.rsf.viewstate.ViewParameters;

public class ShareGame implements DefaultView, ViewComponentProducer {
	
	private static Log log = LogFactory.getLog(ShareGame.class);
	
	public static final String VIEW_ID = "ShareGame";
	public String getViewID() {
		return VIEW_ID;
	}
	
	public void fillComponents(UIContainer tofill, ViewParameters viewparams, ComponentChecker checker) {
		log.info("ShameGame!");
	}
}
