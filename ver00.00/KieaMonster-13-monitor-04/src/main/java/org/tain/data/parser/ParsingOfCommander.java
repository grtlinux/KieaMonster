package org.tain.data.parser;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.controller.BrwWebSocketServerController;
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
	
	@Autowired
	private BrwWebSocketServerController brwWebSocketServerController;
	
	public void parsing(Session session, String message) {
		log.info("KANG-20210615 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			MonJsonNode node = null;
			try {
				node = new MonJsonNode(message);
				String msgKey = node.getText("msgKey");
				log.info("KANG-20210405 >>>>> {} node = {}", msgKey, node.toPrettyString());
				
				switch (msgKey) {
				default:
					//throw new Exception("ERROR: couldn't parse the msgCode [" + msgCode + "]");
					this.brwWebSocketServerController.broadCast(message);
					break;
				}
				
				
			} catch (Exception e) {
				//e.printStackTrace();
				log.error("KANG-20210405 >>>>> error message: {} at {}", e.getMessage(), CurrentInfo.get());
			}
		}
	}
}
