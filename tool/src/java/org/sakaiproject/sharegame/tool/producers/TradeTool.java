package org.sakaiproject.sharegame.tool.producers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.sharegame.logic.ShareGameUser;

import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.components.UIOutput;
import uk.org.ponder.rsf.view.ComponentChecker;
import uk.org.ponder.rsf.view.ViewComponentProducer;
import uk.org.ponder.rsf.viewstate.ViewParameters;

public class TradeTool implements ViewComponentProducer {

	private static Log log = LogFactory.getLog(TradeTool.class);

	public static final String VIEW_ID = "trade";
	
	private ShareGameUser shareGameUser;
	
	public void setShareGameUser(ShareGameUser shareGameUser) {
		this.shareGameUser = shareGameUser;
	}
	@Override
	public String getViewID() {
		return VIEW_ID;
	}

	@Override
	public void fillComponents(UIContainer tofill, ViewParameters viewparams, ComponentChecker checker) {
		log.info("ShareGame!: trade!");
		
		UIOutput.make(tofill, "shareUser", shareGameUser.getName());
	}


}
