package org.sakaiproject.sharegame.tool.producers;

/*
 * #%L
 * sharegame - Tool
 * %%
 * Copyright (C) 2003 - 2015 Sakai Project
 * %%
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *             http://opensource.org/licenses/ecl2
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.sharegame.logic.ShareGameUser;
import org.sakaiproject.sharegame.tool.renderers.NavBarRenderer;

import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.components.UIInternalLink;
import uk.org.ponder.rsf.components.UIMessage;
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
		
		navBarRenderer.makeNavBar(tofill, "navIntraTool:", VIEW_ID); 
				
		UIInternalLink.make(tofill, "CompanyInfo", UIMessage.make("admin_CD"), new SimpleViewParameters(CompanyInfo.VIEW_ID));
		UIInternalLink.make(tofill, "Graphs", UIMessage.make("admin_GR"), new SimpleViewParameters(Graphs.VIEW_ID));
		UIInternalLink.make(tofill, "trade-shares", UIMessage.make("admin_TR"), new SimpleViewParameters(TradeTool.VIEW_ID));
		UIInternalLink.make(tofill, "commerce", UIMessage.make("admin_TS"), new SimpleViewParameters(Commerce.VIEW_ID));	
		
		UIInternalLink.make(tofill, "trading", UIMessage.make("admin_TR"), new SimpleViewParameters(Trading.VIEW_ID));
		UIOutput.make(tofill, "shareUser", shareGameUser.getName() + " (" + shareGameUser.getUserId() + ")");
		
	}



	//public List<NavigationCase> reportNavigationCases() {
	//	List<NavigationCase> togo = new ArrayList<NavigationCase>();
		//togo.add(new NavigationCase(null, new SimpleViewParameters(VIEW_ID)));
		//togo.add(new NavigationCase("Success", new SimpleViewParameters(TradeTool.VIEW_ID)));
		//return togo;
	//}
}
