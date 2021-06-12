package org.tain.working.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.tools.node.MonJsonNode;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PropertiesWork {

	@Autowired
	private ProjEnvParam projEnvParam;
	
	public void working() throws Exception {
		log.info(">>>>> {} {}", "- PARAM --", MonJsonNode.getPrettyJson(this.projEnvParam));
	}
}
