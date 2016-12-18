package org.sakaiproject.sharegame.tool.producers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.sharegame.logic.ShareGameUser;
import org.sakaiproject.sharegame.model.BankAccountsUser;
import org.sakaiproject.sharegame.tool.renderers.NavBarRenderer;

import uk.org.ponder.rsf.components.UIBranchContainer;
import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.components.UIOutput;
import uk.org.ponder.rsf.view.ComponentChecker;
import uk.org.ponder.rsf.view.ViewComponentProducer;
import uk.org.ponder.rsf.viewstate.ViewParameters;

public class Wealth implements ViewComponentProducer {

	private static Log log = LogFactory.getLog(Wealth.class);
	public static final String VIEW_ID = "wealth";
	
	private NavBarRenderer navBarRenderer;
	public void setNavBarRenderer(NavBarRenderer navBarRenderer) {
		this.navBarRenderer = navBarRenderer;
	}
	
	
	private ShareGameUser shareGameUser;
	
	public void setShareGameUser(ShareGameUser shareGameUser) {
		this.shareGameUser = shareGameUser;
	}
	
	@Override
	public void fillComponents(UIContainer tofill, ViewParameters viewparams, ComponentChecker checker) {
		log.info("Wealth");
		navBarRenderer.makeNavBar(tofill, "navIntraTool:", VIEW_ID); 
		List<BankAccountsUser> bu = shareGameUser.getBankAccountsUserSite();
		String currency = shareGameUser.getCurrencyCountry();
		for (int q = 0; q < bu.size(); q++) {
			BankAccountsUser u =  bu.get(q);
			UIBranchContainer row = UIBranchContainer.make(tofill, "user-row:");
			UIOutput.make(row, "user-eid", shareGameUser.getUserSortName(u.getUser()));
			log.debug("Balance: " + new Double(u.getBalance()).toString());
			UIOutput.make(row, "user-currency", currency);
			UIOutput.make(row, "user-wealth", shareGameUser.displayNumber(u.getBalance()));

		}
	}
	
	

	@Override
	public String getViewID() {
		
		return VIEW_ID;
	}

}
