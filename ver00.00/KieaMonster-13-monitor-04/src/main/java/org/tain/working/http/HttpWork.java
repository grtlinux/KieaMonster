package org.tain.working.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.utils.CurrentInfo;
import org.tain.working.http.test.CmdControllerTest;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HttpWork {

	@Autowired
	private CmdControllerTest cmdControllerTest;
	
	public void working() throws Exception {
		log.info("KANG-20210405 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) this.cmdControllerTest.cmdList();
		if (Boolean.TRUE) this.cmdControllerTest.cmdByMstCode();
		if (Boolean.TRUE) this.cmdControllerTest.cmdByCmdCode();
	}
}
