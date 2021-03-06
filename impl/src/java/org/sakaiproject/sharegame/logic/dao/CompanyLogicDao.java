package org.sakaiproject.sharegame.logic.dao;

import java.util.List;

import org.sakaiproject.entity.api.EntityTransferrer;
import org.sakaiproject.entitybroker.DeveloperHelperService;
import org.sakaiproject.genericdao.api.search.Restriction;
import org.sakaiproject.genericdao.api.search.Search;
import org.sakaiproject.sharegame.logic.CompanyLogic;
import org.sakaiproject.sharegame.logic.ShareGameUser;
import org.sakaiproject.sharegame.model.Company;
import org.sakaiproject.sharegame.model.Sector;
import org.sakaiproject.sharegame.model.ShareGameSite;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompanyLogicDao implements EntityTransferrer, CompanyLogic {


	public void init() {
		log.info("init()");
	}

	@Setter
	private ValidationDao dao;

	@Setter
	private DeveloperHelperService developerHelperService;

	@Setter
	private ShareGameUser shareGameUser;
	

	@Override
	public List<Company> getCompany(ShareGameSite site) {
		//addC();
		ShareGameSite sgs = site;
		Search search = new Search();
		Restriction rest = new Restriction("site", sgs.getId());
		search.addRestriction(rest);
		//data = dao.findBySearch(Company.class, new Search()); //, search);
		List<Company> data = dao.findAll(Company.class);
		return data;
	}
	
	public List<Company> getCompany() {
		String siteId = developerHelperService.getCurrentLocationId();
		ShareGameSite sgs = shareGameUser.getShareGameSite(siteId);
		return getCompany(sgs);
	}

	@Override
	public void save(Company c) {
		if (c == null) {
    		throw new IllegalArgumentException("Company can't be null");
    	}
		dao.create(c);
	}

	@Override
	public void sectorSave(Sector s) {
		if (s == null) {
    		throw new IllegalArgumentException("Company can't be null");
    	}
		dao.create(s);
		
	}

	@Override
	public void transferCopyEntities(String fromContext, String toContext, List<String> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] myToolIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transferCopyEntities(String fromContext, String toContext, List<String> ids, boolean cleanup) {
		// TODO Auto-generated method stub
		
	}


	
}
