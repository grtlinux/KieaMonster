package org.tain.working;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.working.http.HttpWork;
import org.tain.working.load.LoadTablesWork;
import org.tain.working.load.test.TestLoadWork;
import org.tain.working.properties.PropertiesWork;

@Component
public class Work {

	public void working() throws Exception {
		if (Boolean.TRUE) propertiesWork();
		if (!Boolean.TRUE) loadWork();  // load.test
		if (Boolean.TRUE) loadTablesWork();  // loadTablesWork
		if (!Boolean.TRUE) httpWork();  // HttoWork
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private PropertiesWork propertiesWork;
	
	private void propertiesWork() throws Exception {
		if (Boolean.TRUE) this.propertiesWork.working();
	}
	
	//////////////
	/////////////////////////////////////////////////////////////
	
	@Autowired
	private TestLoadWork loadWork;
	
	private void loadWork() throws Exception {
		if (Boolean.TRUE) this.loadWork.working();
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private LoadTablesWork loadTablesWork;
	
	private void loadTablesWork() throws Exception {
		if (Boolean.TRUE) this.loadTablesWork.working();
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private HttpWork httpWork;
	
	private void httpWork() throws Exception {
		if (Boolean.TRUE) this.httpWork.working();
	}
}
