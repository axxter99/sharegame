package org.sakaiproject.sharegame.logic.dao;

import org.sakaiproject.entitybroker.DeveloperHelperService;
import org.sakaiproject.sharegame.logic.ShareGameUser;

public class ShareGameUserImp implements ShareGameUser {
	
	private String userId;
	private String uuid;
	private String name;
	private String email;
	
	private DeveloperHelperService developerHelperService;
	public void setDeveloperHelperService(
			DeveloperHelperService developerHelperService) {
		this.developerHelperService = developerHelperService;
	}
	
	@Override
	public String getUserId() {
		
		return null;
	}
	@Override
	public String getUuId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
