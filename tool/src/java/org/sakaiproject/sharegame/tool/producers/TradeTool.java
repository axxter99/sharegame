package org.sakaiproject.sharegame.tool.producers;

import org.sakaiproject.sharegame.logic.ShareGameUser;
import org.sakaiproject.sharegame.tool.renderers.NavBarRenderer;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.components.UIOutput;
import uk.org.ponder.rsf.view.ComponentChecker;
import uk.org.ponder.rsf.view.ViewComponentProducer;
import uk.org.ponder.rsf.viewstate.ViewParameters;

@Slf4j
public class TradeTool implements ViewComponentProducer {


	public static final String VIEW_ID = "trade";
	
	@Setter
	private ShareGameUser shareGameUser;

	@Setter
	private NavBarRenderer navBarRenderer;
	
	
	@Override
	public String getViewID() {
		return VIEW_ID;
	}

	@Override
	public void fillComponents(UIContainer tofill, ViewParameters viewparams, ComponentChecker checker) {
		log.info("ShareGame!: trade!");
		navBarRenderer.makeNavBar(tofill, "navIntraTool:", VIEW_ID); 
		UIOutput.make(tofill, "shareUser", shareGameUser.getName());
	}


}
