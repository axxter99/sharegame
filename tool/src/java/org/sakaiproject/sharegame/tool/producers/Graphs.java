package org.sakaiproject.sharegame.tool.producers;

/*
 * #%L
 * sharegame - Tool
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

import org.sakaiproject.sharegame.tool.renderers.NavBarRenderer;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import uk.org.ponder.rsf.components.UIContainer;
import uk.org.ponder.rsf.view.ComponentChecker;
import uk.org.ponder.rsf.view.ViewComponentProducer;
import uk.org.ponder.rsf.viewstate.ViewParameters;

@Slf4j
public class Graphs implements ViewComponentProducer {


	@Setter
	private NavBarRenderer navBarRenderer;

	public static final String VIEW_ID = "graphs";
	@Override
	public void fillComponents(UIContainer tofill, ViewParameters viewparams, ComponentChecker checker) {
		log.info("Graphs!");
		navBarRenderer.makeNavBar(tofill, "navIntraTool:", VIEW_ID); 

	}

	@Override
	public String getViewID() {
		
		return VIEW_ID;
	}

}
