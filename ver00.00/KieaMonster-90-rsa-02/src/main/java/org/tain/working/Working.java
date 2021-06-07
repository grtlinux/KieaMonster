package org.tain.working;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.working.workProperties.WorkProperties;

@Component
public class Working {

	@Autowired
	private WorkProperties workProperties;
	
	public void work01() throws Exception {
		this.workProperties.print();
	}
	
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
}
