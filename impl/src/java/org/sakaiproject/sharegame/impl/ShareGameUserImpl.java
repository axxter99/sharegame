package org.sakaiproject.sharegame.impl;

import java.text.NumberFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.mapping.Collection;
import org.joda.money.CurrencyUnit;
import org.sakaiproject.authz.api.Member;
import org.sakaiproject.component.api.ServerConfigurationService;
import org.sakaiproject.entitybroker.DeveloperHelperService;
import org.sakaiproject.exception.IdUnusedException;
import org.sakaiproject.exception.PermissionException;
import org.sakaiproject.genericdao.api.search.Restriction;
import org.sakaiproject.genericdao.api.search.Search;
import org.sakaiproject.sharegame.logic.ShareGameUser;
import org.sakaiproject.sharegame.logic.dao.ValidationDao;
import org.sakaiproject.sharegame.model.BankAccountsUser;
import org.sakaiproject.sharegame.model.ShareGameSite;
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
	
	
	private ValidationDao dao;
	public void setDao(ValidationDao dao) {
		this.dao = dao;
	}


	@Override
	public String getUserId() {
		return userDirectoryService.getCurrentUser().getEid();
	}

	private ServerConfigurationService serverConfigurationService;
	public void setServerConfigurationService(
			ServerConfigurationService serverConfigurationService) {
		this.serverConfigurationService = serverConfigurationService;
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
		ShareGameSite sgs = getShareGameSite(siteId);
		List<BankAccountsUser> bu = new ArrayList<BankAccountsUser>();
		try {
			Site site = siteService.getSiteVisit(siteId);
			Set<Member> member = site.getMembers();
			bu = getBankAccountsUserSite(member, sgs);
		} catch (IdUnusedException e) {
			log.debug("IdUnusedException", e);
		} catch (PermissionException e) {
			log.error("PermissionException", e);
		}
		return bu;
	}
	
	public List<BankAccountsUser> getBankAccountsUserSite(Set<Member> member, ShareGameSite site) {
		 ShareGameSite sgs = site;
		 Search search = new Search();
		 Restriction rest = new Restriction("site", sgs.getId());
		 search.addRestriction(rest);
		 List<BankAccountsUser> data = dao.findBySearch(BankAccountsUser.class, search);
		 log.debug("getBankAccountsUserSite: " + data.size());
		if (0 == data.size()) {
			log.debug("getBankAccountsUserSite: 0!");
			Iterator<Member> iterator = member.iterator();
			Set<BankAccountsUser> id = new HashSet<BankAccountsUser>();
			while (iterator.hasNext()) {			
				Member m = iterator.next();
				//log.debug("Member: " + m.getUserEid() + " (" + m.getUserId() + ")");
				BankAccountsUser bu = new BankAccountsUser(m.getUserId());
				bu.setBalance(sgs.getBalance());
				bu.setSite(sgs.getId());
				bu.setCreationDate(new Date());
				bu.setModefiedOn(new Date());
				dao.create(bu);
				id.add(bu);
				iterator.remove();
			}
			//Set<BankAccountsUser> t = dao.saveSet(BankAccountsUser.class, id);
			log.debug("BankAccountsUser; " + id.size()); 
			data = dao.findBySearch(BankAccountsUser.class, search);
		 }
			 
		/* 
		List<BankAccountsUser> bankAccountsUser = new ArrayList<BankAccountsUser>();
		Iterator<Member> iterator = member.iterator();
		while (iterator.hasNext()) {
			
			
			Member m = iterator.next();
			log.debug("Menber: " + m.getUserEid() + " (" + m.getUserId() + ")");
			BankAccountsUser bu = new BankAccountsUser(m.getUserId());
			bu.setBalance(sgs.getBalance());
			bankAccountsUser.add(bu);
			iterator.remove();
		} */
		return data;
	}

	@Override
	public String displayNumber(Double l) {
		Double amount = l;
		NumberFormat numberFormatter;

		String amountOut;

		Locale currentLocale = developerHelperService.getCurrentLocale();
		numberFormatter = NumberFormat.getNumberInstance(currentLocale);

		amountOut = numberFormatter.format(amount);

		//log.debug(amountOut + "   " + currentLocale.toString());
		return amountOut;
	}






	@Override
	public ShareGameSite getShareGameSite() {
		
		return getShareGameSite(developerHelperService.getCurrentLocationId());
	}






	@Override
	public ShareGameSite getShareGameSite(String ref) {
		log.debug("getShareGameSite: "  + ref);
		List<ShareGameSite> data = dao.findBySearch(ShareGameSite.class, new Search("site", ref));
		
		ShareGameSite sgs;
		log.debug("data: " + data.size());
		if (0 == data.size()) {
			sgs = new ShareGameSite();
			sgs.setSite(ref);
			sgs.setBalance(getBalance());
			sgs.setCurrency(getCurrency());
			dao.create(sgs);
		} else {
			sgs = (ShareGameSite)data.get(0); ;
		}
		return sgs;
	}

	//sakai.properties
	private Double getBalance() {
		Double BALANCE = new Double(serverConfigurationService.getString("sharegame.Balance", "1000000"));
		return BALANCE;
	}
	
	private String getCurrency() {
		String curreny = serverConfigurationService.getString("sharegame.Currency", "USD");
		return curreny;
	}
}
