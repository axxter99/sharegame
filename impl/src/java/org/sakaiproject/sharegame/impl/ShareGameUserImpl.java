package org.sakaiproject.sharegame.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.sharegame.logic.ShareGameUser;
import org.sakaiproject.user.api.UserDirectoryService;

public class ShareGameUserImpl implements ShareGameUser {
	
	private static Log log = LogFactory.getLog(ShareGameUserImpl.class);
	
	public void init(){
		log.info("init()");
	}
	

	
	private UserDirectoryService userDirectoryService;
	public void setUserDirectoryService(UserDirectoryService userDirectoryService) {
		this.userDirectoryService = userDirectoryService;
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
		
		return userDirectoryService.getCurrentUser().getFirstName() + " " + userDirectoryService.getCurrentUser().getLastName();
	}
	@Override
	public String getEmail() {
		
		return userDirectoryService.getCurrentUser().getEmail();
	}
	
	

}
