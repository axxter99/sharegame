package org.sakaiproject.sharegame.tool.producers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.sharegame.logic.ShareGameUser;

import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.components.UIInternalLink;
import uk.org.ponder.rsf.components.UIOutput;
import uk.org.ponder.rsf.view.ComponentChecker;
import uk.org.ponder.rsf.view.ViewComponentProducer;
import uk.org.ponder.rsf.viewstate.SimpleViewParameters;
import uk.org.ponder.rsf.viewstate.ViewParameters;

public class Commerce implements ViewComponentProducer {

	private static Log log = LogFactory.getLog(Commerce.class);
	
	private ShareGameUser shareGameUser;
	
	public void setShareGameUser(ShareGameUser shareGameUser) {
		this.shareGameUser = shareGameUser;
	}
	
	public static final String VIEW_ID = "commerce";
	@Override
	public void fillComponents(UIContainer tofill, ViewParameters viewparams, ComponentChecker checker) {
		// TODO Auto-generated method stub
		log.info("commerce!");

		UIOutput.make(tofill, "shareUser", shareGameUser.getName() + " (" + shareGameUser.getUserId() + ")");
		UIInternalLink.make(tofill, "trading", new SimpleViewParameters(TradeTool.VIEW_ID));
	}

	@Override
	public String getViewID() {
		return VIEW_ID;
		
	}

}
