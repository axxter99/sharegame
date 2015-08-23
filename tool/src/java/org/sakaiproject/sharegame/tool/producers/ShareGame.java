package org.sakaiproject.sharegame.tool.producers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.entitybroker.DeveloperHelperService;

import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.components.UIInternalLink;
import uk.org.ponder.rsf.components.UIOutput;
import uk.org.ponder.rsf.view.ComponentChecker;
import uk.org.ponder.rsf.view.DefaultView;
import uk.org.ponder.rsf.view.ViewComponentProducer;
import uk.org.ponder.rsf.viewstate.SimpleViewParameters;
import uk.org.ponder.rsf.viewstate.ViewParameters;

public class ShareGame implements DefaultView, ViewComponentProducer {
//, NavigationCaseReporter
	private static Log log = LogFactory.getLog(ShareGame.class);

	public static final String VIEW_ID = "share";

	public String getViewID() {
		return VIEW_ID;
	}

	private DeveloperHelperService developerHelperService;
	public void setDeveloperHelperService(
			DeveloperHelperService developerHelperService) {
		this.developerHelperService = developerHelperService;
	}

	public void fillComponents(UIContainer tofill, ViewParameters viewparams, ComponentChecker checker) {
		log.info("ShareGame!");
		log.info("user: " + developerHelperService.getCurrentUserId() + "(" + developerHelperService.getCurrentUserReference() +")");

		UIInternalLink.make(tofill, "trade-shares", new SimpleViewParameters(TradeTool.VIEW_ID));
		UIInternalLink.make(tofill, "commerce", new SimpleViewParameters(Commerce.VIEW_ID));
		UIOutput.make(tofill, "shareUser", developerHelperService.getCurrentUserId());
		
	}

	//public List<NavigationCase> reportNavigationCases() {
	//	List<NavigationCase> togo = new ArrayList<NavigationCase>();
		//togo.add(new NavigationCase(null, new SimpleViewParameters(VIEW_ID)));
		//togo.add(new NavigationCase("Success", new SimpleViewParameters(TradeTool.VIEW_ID)));
		//return togo;
	//}
}
