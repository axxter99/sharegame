package org.sakaiproject.sharegame.logic.dao;

/*
 * #%L
 * sharegame - Implementation
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

import java.util.ArrayList;
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
