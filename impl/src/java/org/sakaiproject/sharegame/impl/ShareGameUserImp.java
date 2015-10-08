package org.sakaiproject.sharegame.impl;

import org.sakaiproject.entitybroker.DeveloperHelperService;
import org.sakaiproject.sharegame.logic.ShareGameUser;
import org.sakaiproject.user.api.UserDirectoryService;

public class ShareGameUserImp implements ShareGameUser {

	private DeveloperHelperService developerHelperService;
	public void setDeveloperHelperService(
			DeveloperHelperService developerHelperService) {
		this.developerHelperService = developerHelperService;
	}
	
	private UserDirectoryService userDirectoryService;
	public void setUserDirectoryService(UserDirectoryService userDirectoryService) {
		this.userDirectoryService = userDirectoryService;
	}
	
	@Override
	public String getUserId() {
		
		return developerHelperService.getCurrentUserId();
	}
	@Override
	public String getUuId() {
		
		return userDirectoryService.getCurrentUser().getEid();
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return userDirectoryService.getCurrentUser().getFirstName() + " " + userDirectoryService.getCurrentUser().getLastName();
	}
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return userDirectoryService.getCurrentUser().getEmail();
	}
	
	

}
