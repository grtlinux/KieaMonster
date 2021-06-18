package org.tain.data.parser;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.controller.BrwWebSocketServerController;
import org.tain.data.WorkingData;
import org.tain.data.vo.Brw;
import org.tain.tools.node.MonJsonNode;
import org.tain.utils.CurrentInfo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ParsingOfBrowser {

	@Autowired
	private WorkingData workingData;
	
	@Autowired
	private BrwWebSocketServerController brwWebSocketServerController;
	
	public void parsing(Session session, String message) {
		log.info("KANG-20210615 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			MonJsonNode reqNode = null;
			MonJsonNode resNode = null;
			try {
				reqNode = new MonJsonNode(message);
				
				String msgKey = reqNode.getText("msgKey");
				log.info("KANG-20210405 >>>>> {} reqNode = {}", msgKey, reqNode.toPrettyString());
				
				switch (msgKey) {
				case "BRW001":  // 브라우져 접속 초기 요청
					if (Boolean.TRUE) {
						// register to map
						String sessId = session.getId();
						Brw brw = Brw.builder()
								.sessId(sessId)
								.session(session)
								.cmdCode(reqNode.getText("cmdCode"))
								.build();
						this.workingData.getMapBrw().put(sessId, brw);
						log.info(">>>>> mapBrw = {}", this.workingData.getMapBrw());
					}
					if (Boolean.TRUE) {
						// 브라우져 접속 초기 요청에 대한 응답
						resNode = reqNode.clone();
						resNode.put("msgType", "RES");
						resNode.put("sessId", session.getId());
						resNode.put("resCode", "000");
						resNode.put("resMsg", "SUCCESS ON REGISTRATION OF BRW");
						this.brwWebSocketServerController.sendMessage(session, resNode.toString());
					}
					break;
				default:
					this.workingData.getQueueFromBrowserToCommander().set(reqNode);
					//throw new Exception("ERROR: couldn't parse the msgCode [" + msgCode + "]");
				}
			} catch (Exception e) {
				//e.printStackTrace();
				log.error("KANG-20210405 >>>>> error message: {} at {}", e.getMessage(), CurrentInfo.get());
			}
		}
	}
}
