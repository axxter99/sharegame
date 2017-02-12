package org.sakaiproject.sharegame.logic.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.entitybroker.DeveloperHelperService;
import org.sakaiproject.genericdao.api.search.Restriction;
import org.sakaiproject.genericdao.api.search.Search;
import org.sakaiproject.sharegame.logic.CompanyLogic;
import org.sakaiproject.sharegame.logic.ShareGameUser;
import org.sakaiproject.sharegame.model.Company;
import org.sakaiproject.sharegame.model.Sector;
import org.sakaiproject.sharegame.model.ShareGameSite;

public class CompanyLogicDao implements CompanyLogic {

	private static Log log = LogFactory.getLog(CompanyLogicDao.class);

	public void init() {
		log.info("init()");
	}

	private ValidationDao dao;
	public void setDao(ValidationDao dao) {
		this.dao = dao;
	}
	
	
	private DeveloperHelperService developerHelperService;

	public void setDeveloperHelperService(DeveloperHelperService developerHelperService) {
		this.developerHelperService = developerHelperService;
	}
	
	private ShareGameUser shareGameUser;
	
	public void setShareGameUser(ShareGameUser shareGameUser) {
		this.shareGameUser = shareGameUser;
	}

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
		
		dao.create(c);
	}

	@Override
	public void sectorSave(Sector s) {
		dao.create(s);
		
	}


	
}
