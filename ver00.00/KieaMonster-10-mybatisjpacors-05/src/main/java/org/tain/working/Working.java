package org.tain.working;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.working.properties.PropertiesWorking;

@Component
public class Working {

	@Autowired
	private PropertiesWorking propertiesWorking;
	
	public void work() throws Exception {
		this.propertiesWorking.work();
	}
}
