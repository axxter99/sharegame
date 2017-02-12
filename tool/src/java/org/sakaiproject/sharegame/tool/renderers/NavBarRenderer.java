package org.sakaiproject.sharegame.tool.renderers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sakaiproject.sharegame.model.Trade;
import org.sakaiproject.sharegame.tool.producers.Commerce;
import org.sakaiproject.sharegame.tool.producers.CompanyInfo;
import org.sakaiproject.sharegame.tool.producers.Graphs;
import org.sakaiproject.sharegame.tool.producers.TradeTool;
import org.sakaiproject.sharegame.tool.producers.Trading;
import org.sakaiproject.sharegame.tool.producers.Wealth;

import uk.org.ponder.messageutil.MessageLocator;
import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.components.UIInternalLink;
import uk.org.ponder.rsf.components.UIJointContainer;
import uk.org.ponder.rsf.components.UIMessage;
import uk.org.ponder.rsf.viewstate.SimpleViewParameters;

public class NavBarRenderer {

	private MessageLocator messageLocator;
	
	public void setMessageLocator(MessageLocator messageLocator) {
		this.messageLocator = messageLocator;
	}
	private static Logger log = LoggerFactory.getLogger(NavBarRenderer.class);
	/**
	 * Renderer for the nav bar. If @param currentUserId AND @param currentSiteId are null or invalid, nav bar will not render the permissions link
	 * @param tofill
	 * @param divID
	 * @param currentViewID
	 */
	public void makeNavBar(UIContainer tofill, String divID, String currentViewID){
		
		
		UIJointContainer joint = new UIJointContainer(tofill, divID,"sharegame-navigation:");

		UIInternalLink.make(joint, "CompanyInfo", UIMessage.make("admin_CD"), new SimpleViewParameters(CompanyInfo.VIEW_ID));
		UIInternalLink.make(joint, "Graphs", UIMessage.make("admin_GR"), new SimpleViewParameters(Graphs.VIEW_ID));
		
		UIInternalLink.make(joint, "trade-shares", UIMessage.make("admin_TradingHistory"), new SimpleViewParameters(TradeTool.VIEW_ID));
		UIInternalLink.make(joint, "trading", UIMessage.make("admin_TradeRules"), new SimpleViewParameters(Trading.VIEW_ID));
		//UIInternalLink.make(joint, "commerce", new SimpleViewParameters(Commerce.VIEW_ID));		
		
		UIInternalLink.make(joint, "wealth", UIMessage.make("admin_W"), new SimpleViewParameters(Wealth.VIEW_ID));
	};
}
