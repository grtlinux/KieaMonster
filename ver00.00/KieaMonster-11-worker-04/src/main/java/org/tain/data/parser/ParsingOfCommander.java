package org.tain.data.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.data.WorkingData;
import org.tain.tools.node.MonJsonNode;
import org.tain.utils.CurrentInfo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ParsingOfCommander {

	@SuppressWarnings("unused")
	@Autowired
	private WorkingData workingData;
	
	public void parsing(String message) {
		log.info("KANG-20210615 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			MonJsonNode node = null;
			try {
				node = new MonJsonNode(message);
				log.info("KANG-20210405 >>>>> {} reqNode = {}", CurrentInfo.get(), node.toPrettyString());
				
				String msgKey = node.getText("msgKey");
				switch (msgKey) {
				default:
					throw new Exception("ERROR: couldn't parse the msgKey [" + msgKey + "]");
					//break;
				}
			} catch (Exception e) {
				//e.printStackTrace();
				log.error("KANG-20210405 >>>>> error message: {} at {}", e.getMessage(), CurrentInfo.get());
			}
		}
	}
}
