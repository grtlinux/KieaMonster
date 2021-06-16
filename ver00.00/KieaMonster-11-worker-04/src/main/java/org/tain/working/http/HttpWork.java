package org.tain.working.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.tools.node.MonJsonNode;
import org.tain.tools.properties.ProjEnvParam;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HttpWork {

	@Autowired
	private ProjEnvParam projEnvParam;
	
	public void working() throws Exception {
		if (Boolean.TRUE) log.info(">>>>> {} {}", "- PARAM --", MonJsonNode.getPrettyJson(this.projEnvParam));
	}
}
