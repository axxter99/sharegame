package org.sakaiproject.sharegame.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author dhorwitz
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class trade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private long id;
	private String symbol;
	private String company;
	
}
