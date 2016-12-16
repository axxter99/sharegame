package org.sakaiproject.sharegame.tool.renderers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.sharegame.tool.producers.Commerce;
import org.sakaiproject.sharegame.tool.producers.CompanyInfo;
import org.sakaiproject.sharegame.tool.producers.Graphs;
import org.sakaiproject.sharegame.tool.producers.TradeTool;

import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.components.UIInternalLink;
import uk.org.ponder.rsf.components.UIJointContainer;
import uk.org.ponder.rsf.viewstate.SimpleViewParameters;

public class NavBarRenderer {


	private static Log log = LogFactory.getLog(NavBarRenderer.class);
	/**
	 * Renderer for the nav bar. If @param currentUserId AND @param currentSiteId are null or invalid, nav bar will not render the permissions link
	 * @param tofill
	 * @param divID
	 * @param currentViewID
	 */
	public void makeNavBar(UIContainer tofill, String divID, String currentViewID){
		log.info("OK!");
		UIJointContainer joint = new UIJointContainer(tofill, divID,"sharegame-navigation:");
		UIInternalLink.make(joint, "trade-shares", new SimpleViewParameters(TradeTool.VIEW_ID));
		UIInternalLink.make(joint, "commerce", new SimpleViewParameters(Commerce.VIEW_ID));
		UIInternalLink.make(joint, "CompanyInfo", new SimpleViewParameters(CompanyInfo.VIEW_ID));
		UIInternalLink.make(joint, "Graphs", new SimpleViewParameters(Graphs.VIEW_ID));
	};
}
