package org.sakaiproject.sharegame.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.sakaiproject.sharegame.logic.dao.CompanyLogicDao;
import org.sakaiproject.sharegame.logic.dao.ValidationDao;
import org.sakaiproject.sharegame.model.Company;
import org.sakaiproject.sharegame.model.Sector;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompanyLogicImplTest {
	
	
	private CompanyLogicDao companyLogic;
	
	@Before
	public void onSetUp() {
		
		
		ValidationDao dao = Mockito.mock(ValidationDao.class);
		companyLogic = new CompanyLogicDao();
		companyLogic.setDao(dao);
	}
	
	@Test
	public void testValidate() {
		
		
		
		
		
		//Assert.assertEquals(1,1);
		//Assert.assertEquals(1,2);
		
		try {
			companyLogic.save(null);
			Assert.fail();
		}
		catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
		}
		
		Company a = new Company();
		
		
	}
	
	@Test
	public void testSector() {
		Sector a = new Sector();
		a.setSector("qwert");
		//Assert.assertEquals(1,1);
		//Assert.assertEquals(1,2);
		
		try {
			companyLogic.sectorSave(null);
			Assert.fail();
		}
		catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
		}
		
		try {
			companyLogic.sectorSave(a);
			log.info("Sector: " + a.getId() + a.getSector());
			//Assert.assertEquals(1, a.getId().longValue());
		}
		catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			Assert.fail();
		}
	}

}
