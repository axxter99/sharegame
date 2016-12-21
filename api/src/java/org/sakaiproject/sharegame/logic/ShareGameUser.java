package org.sakaiproject.sharegame.logic;

import java.util.List;


import org.sakaiproject.sharegame.model.BankAccountsUser;
import org.sakaiproject.sharegame.model.ShareGameSite;

/*
 * #%L
 * sharegame - API
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





/**
 * @author dhorwitz
 *
 */
public interface ShareGameUser {

	

	/**
	 * @return
	 */
	public String getUserId();
	
	
	public String getUuId();
	public String getName();
	public String getEmail();
		
	public String getUserSortName();
	public String getUserSortName(String id);
	/*
	 * Currency
	 * @return
	 */
	public String getCurrencyCountry();
	
	/*
	 * User Bank Accounts
	 * @return
	 */
	public  Double getUserBankAccounts();
	
	/*
	 * User Bank Accounts
	 * @return
	 */
	public  Double getUserBankAccounts(String user);

	
	public List<BankAccountsUser> getBankAccountsUserSite();
	
	public String displayNumber(Double l);
	
	public ShareGameSite getShareGameSite();
	public ShareGameSite getShareGameSite(String ref);
	
}
	
