package org.sakaiproject.sharegame.tool.producers;

import org.sakaiproject.sharegame.logic.ShareGameUser;
import org.sakaiproject.sharegame.model.ShareGameSite;
import org.sakaiproject.sharegame.tool.renderers.NavBarRenderer;

import lombok.extern.slf4j.Slf4j;
import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.components.UIInternalLink;
import uk.org.ponder.rsf.components.UIMessage;
import uk.org.ponder.rsf.components.UIOutput;
import uk.org.ponder.rsf.view.ComponentChecker;
import uk.org.ponder.rsf.view.DefaultView;
import uk.org.ponder.rsf.view.ViewComponentProducer;
import uk.org.ponder.rsf.viewstate.SimpleViewParameters;
import uk.org.ponder.rsf.viewstate.ViewParameters;

@Slf4j
public class ShareGame implements DefaultView, ViewComponentProducer {
//, NavigationCaseReporter


	public static final String VIEW_ID = "share";

	public String getViewID() {
		return VIEW_ID;
	}


	private ShareGameUser shareGameUser;
	
	public void setShareGameUser(ShareGameUser shareGameUser) {
		this.shareGameUser = shareGameUser;
	}

	private NavBarRenderer navBarRenderer;
	public void setNavBarRenderer(NavBarRenderer navBarRenderer) {
		this.navBarRenderer = navBarRenderer;
	}
	


	public void fillComponents(UIContainer tofill, ViewParameters viewparams, ComponentChecker checker) {
		log.debug("ShareGame!");
		log.debug("user: " + shareGameUser.getUserId() + "(" + shareGameUser.getUuId() +")");
		
		ShareGameSite sgs = shareGameUser.getShareGameSite();
		log.debug("ShareGameSite: " + sgs.getSite());
		navBarRenderer.makeNavBar(tofill, "navIntraTool:", VIEW_ID); 
				
		UIInternalLink.make(tofill, "CompanyInfo", UIMessage.make("admin_CD"), new SimpleViewParameters(CompanyInfo.VIEW_ID));
		UIInternalLink.make(tofill, "Graphs", UIMessage.make("admin_GR"), new SimpleViewParameters(Graphs.VIEW_ID));
		UIInternalLink.make(tofill, "trade-shares", UIMessage.make("admin_TradingHistory"), new SimpleViewParameters(TradeTool.VIEW_ID));
		UIInternalLink.make(tofill, "trading", UIMessage.make("admin_TradeRules"), new SimpleViewParameters(Trading.VIEW_ID));
		UIInternalLink.make(tofill, "commerce", new SimpleViewParameters(Commerce.VIEW_ID));	
		
		UIOutput.make(tofill, "shareUser", shareGameUser.getName() + " (" + shareGameUser.getUserId() + ")");
		
	}



	//public List<NavigationCase> reportNavigationCases() {
	//	List<NavigationCase> togo = new ArrayList<NavigationCase>();
		//togo.add(new NavigationCase(null, new SimpleViewParameters(VIEW_ID)));
		//togo.add(new NavigationCase("Success", new SimpleViewParameters(TradeTool.VIEW_ID)));
		//return togo;
	//}
}
