package org.sakaiproject.sharegame.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.money.CurrencyUnit;
import org.sakaiproject.authz.api.Member;
import org.sakaiproject.entitybroker.DeveloperHelperService;
import org.sakaiproject.exception.IdUnusedException;
import org.sakaiproject.exception.PermissionException;
import org.sakaiproject.sharegame.logic.ShareGameUser;
import org.sakaiproject.sharegame.model.BankAccountsUser;
import org.sakaiproject.site.api.Site;
import org.sakaiproject.site.api.SiteService;
import org.sakaiproject.user.api.User;
import org.sakaiproject.user.api.UserDirectoryService;
import org.sakaiproject.user.api.UserNotDefinedException;

public class ShareGameUserImpl implements ShareGameUser {
	
	//private static final boolean int = false;
	private static Log log = LogFactory.getLog(ShareGameUserImpl.class);
	
	public void init(){
		log.info("init()");
	}
	

	
	private UserDirectoryService userDirectoryService;
	public void setUserDirectoryService(UserDirectoryService userDirectoryService) {
		this.userDirectoryService = userDirectoryService;
	}
	
	private DeveloperHelperService developerHelperService;
	public void setDeveloperHelperService(DeveloperHelperService developerHelperService) {
		this.developerHelperService = developerHelperService;
	}
	
	private SiteService siteService;
	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}
	
	
	
	
	
	
	@Override
	public String getUserId() {
		return userDirectoryService.getCurrentUser().getEid();
	}

	
	@Override
	public String getUuId() {
		
		return userDirectoryService.getCurrentUser().getId();
	}
	@Override
	public String getName() {
		
		return userDirectoryService.getCurrentUser().getDisplayName();
	}
	@Override
	public String getEmail() {
		
		return userDirectoryService.getCurrentUser().getEmail();
	}
	
	@Override
	public String getUserSortName() {
		
		return userDirectoryService.getCurrentUser().getSortName();
	}
	@Override
	public String getUserSortName(String id) {
		try {
			User user = userDirectoryService.getUser(id);
			String sortName = user.getSortName();
			return sortName;
		} catch (UserNotDefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public String getCurrencyCountry() {
		log.debug("getCurrencyCountry ");
		Locale locale = developerHelperService.getCurrentLocale();
		
		CurrencyUnit cu = CurrencyUnit.getInstance(locale);
		return cu.getCode();
	}
	@Override
	public  Double  getUserBankAccounts() {
		// TODO Auto-generated method stub
		return  new Double("100000.00");
	}
	@Override
	public Double  getUserBankAccounts(String user) {
		// TODO Auto-generated method stub
		return getUserBankAccounts();
	}
	@Override
	public List<BankAccountsUser> getBankAccountsUserSite()  {
		String siteId = developerHelperService.getCurrentLocationId();  //.getCurrentLocationReference();
		log.debug("Site: " + siteId);
		List<BankAccountsUser> bu = new ArrayList<BankAccountsUser>();;
		try {
			Site site = siteService.getSiteVisit(siteId);
			Set<Member> member = site.getMembers();
			bu = getBankAccountsUserSite(member, 0);
		} catch (IdUnusedException e) {
			log.error("IdUnusedException", e);
		} catch (PermissionException e) {
			log.error("PermissionException", e);
		}
		return bu;
	}
	
	public List<BankAccountsUser> getBankAccountsUserSite(Set<Member> member, long site) {
		List<BankAccountsUser> bankAccountsUser = new ArrayList<BankAccountsUser>();
		Iterator<Member> iterator = member.iterator();
		while (iterator.hasNext()) {
			Member m = iterator.next();
			log.debug("Menber: " + m.getUserEid() + " (" + m.getUserId() + ")");
			BankAccountsUser bu = new BankAccountsUser(m.getUserId());
			// TODO setBalance
			bu.setBalance(new Double("1000000.00"));
			bankAccountsUser.add(bu);
			iterator.remove();
		}
		return bankAccountsUser;
	}

	@Override
	public String displayNumber(Double l) {
		Double amount = l;
		NumberFormat numberFormatter;

		String amountOut;

		Locale currentLocale = developerHelperService.getCurrentLocale();
		numberFormatter = NumberFormat.getNumberInstance(currentLocale);

		amountOut = numberFormatter.format(amount);

		log.debug(amountOut + "   " + currentLocale.toString());
		return amountOut;
	}


}
