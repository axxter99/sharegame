package org.sakaiproject.sharegame.test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.sakaiproject.genericdao.api.search.Search;
import org.sakaiproject.sharegame.logic.ShareGameUser;
import org.sakaiproject.sharegame.impl.ShareGameUserImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class ShareGameUserImplTest {

    /**
     * This is to test a specific bug where the wrong sites were being searched when asking for just one site.
     */
    @Test
    public void testGetPollForUserCorrectSites() {
    	

    	ShareGameUser impl = new ShareGameUserImpl();
        
    }
}