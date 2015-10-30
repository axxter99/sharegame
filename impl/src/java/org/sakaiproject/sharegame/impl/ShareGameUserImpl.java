package org.sakaiproject.sharegame.impl;

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
		
		return userDirectoryService.getCurrentUser().getDisplayName();
	}
	@Override
	public String getEmail() {
		
		return userDirectoryService.getCurrentUser().getEmail();
	}
	
	

}
