package org.sakaiproject.sharegame.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShareGameSite implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String site;
	
	

}
