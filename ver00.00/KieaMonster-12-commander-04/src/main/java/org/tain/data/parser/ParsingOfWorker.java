package org.tain.data.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.data.WorkingData;
import org.tain.tools.node.MonJsonNode;
import org.tain.utils.CurrentInfo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ParsingOfWorker {

	@Autowired
	private WorkingData workingData;
	
	public void parsing(String message) {
		log.info("KANG-20210615 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			MonJsonNode node = null;
			try {
				node = new MonJsonNode(message);
				log.info("KANG-20210405 >>>>> {} reqNode = {}", CurrentInfo.get(), node.toPrettyString());
				
				this.workingData.getQueueFromWorkerToMonitor().set(node);
				/*
				String msgCode = node.getText("msgCode");
				switch (msgCode) {
				case "GET_CMDS":
					// transfer to SplitCommandsTask
					this.workingData.getQueue().set(node);
					break;
				default:
					throw new Exception("ERROR: couldn't parse the msgCode [" + msgCode + "]");
					//break;
				}
				*/
			} catch (Exception e) {
				//e.printStackTrace();
				log.error("KANG-20210405 >>>>> error message: {} at {}", e.getMessage(), CurrentInfo.get());
			}
		}
	}
}
