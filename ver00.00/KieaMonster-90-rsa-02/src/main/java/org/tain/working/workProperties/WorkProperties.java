package org.tain.working.workProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.node.MonJsonNode;
import org.tain.properties.ProjEnvBase;
import org.tain.properties.ProjEnvJob;
import org.tain.properties.ProjEnvJson;
import org.tain.properties.ProjEnvParam;
import org.tain.properties.ProjEnvUrl;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Flag;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WorkProperties {

	@Autowired
	private ProjEnvBase projEnvBaseProperties;
	
	@Autowired
	private ProjEnvJob projEnvJobProperties;
	
	@Autowired
	private ProjEnvJson projEnvJsonProperties;
	
	@Autowired
	private ProjEnvUrl projEnvUrlProperties;
	
	@Autowired
	private ProjEnvParam projEnvParamProperties;
	
	public void print() throws Exception {
		log.info("KANG-20210405 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			log.info("KANG-20210405 >>>>> {} {}", "- BASE --", MonJsonNode.getPrettyJson(this.projEnvBaseProperties));
			log.info("KANG-20210405 >>>>> {} {}", "- PARAM -", MonJsonNode.getPrettyJson(this.projEnvParamProperties));
			log.info("KANG-20210405 >>>>> {} {}", "- JOB  --", MonJsonNode.getPrettyJson(this.projEnvJobProperties));
			log.info("KANG-20210405 >>>>> {} {}", "- JSON --", MonJsonNode.getPrettyJson(this.projEnvJsonProperties));
			log.info("KANG-20210405 >>>>> {} {}", "- URL  --", MonJsonNode.getPrettyJson(this.projEnvUrlProperties));
		}
	}
}
