package org.sakaiproject.sharegame.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Bank Accounts User
 * @author dhorwitz
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountsUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String user;
	
	private long c;
	
	
}
