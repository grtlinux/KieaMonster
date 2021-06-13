package org.tain.working;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.working.load.test.TestLoadWork;
import org.tain.working.properties.PropertiesWork;

@Component
public class Work {

	public void working() throws Exception {
		if (Boolean.TRUE) propertiesWork();
		if (Boolean.TRUE) loadWork();
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private PropertiesWork propertiesWork;
	
	private void propertiesWork() throws Exception {
		if (Boolean.TRUE) this.propertiesWork.working();
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private TestLoadWork loadWork;
	
	private void loadWork() throws Exception {
		if (Boolean.TRUE) this.loadWork.working();
	}
}
