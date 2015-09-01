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
/**CREATE TABLE bankaccounts (
    mid character varying(10) NOT NULL,
    balance numeric(20,4) DEFAULT 0 NOT NULL
);
**/
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String user;
	
	private long balance;
	
	
}
