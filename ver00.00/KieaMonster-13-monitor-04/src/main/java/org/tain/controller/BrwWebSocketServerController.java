package org.tain.controller;

import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.tain.config.websocket.CustomSpringConfig;
import org.tain.data.WorkingData;
import org.tain.data.parser.ParsingOfBrowser;
import org.tain.data.vo.Brw;
import org.tain.tools.node.MonJsonNode;

@Controller
@ServerEndpoint(value = "/wsBrw", configurator = CustomSpringConfig.class)
public class BrwWebSocketServerController {

	@Autowired
	private WorkingData workingData;
	
	@Autowired
	private ParsingOfBrowser parsingOfBrowser;
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println(">>>>> [wsBrw.OnOpen] session.getId(): " + session.getId());
		this.workingData.getBrwSessions().add(session);
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		System.out.printf(">>>>> [wsBrw.OnMessage] session.getId(): %s, message: %s\n", session.getId(), message);
		if (Boolean.TRUE) {
			this.parsingOfBrowser.parsing(session, message);
		}
	}
	
	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println(">>>>> [wsBrw.OnError] session.getId(): " + session.getId());
		this.workingData.getBrwSessions().remove(session);
		this.workingData.getMapBrw().remove(session.getId());
		t.printStackTrace();
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println(">>>>> [wsBrw.OnClose] session.getId(): " + session.getId());
		this.workingData.getBrwSessions().remove(session);
		this.workingData.getMapBrw().remove(session.getId());
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public void broadCast(MonJsonNode node) {
		//System.out.println(">>>>> [wsBrw.broadCast]: " + node.toString());
		if (!Boolean.TRUE) {
			this.workingData.getBrwSessions().forEach(session -> {
				this.sendMessage(session, node.toString());
			});
		}
		if (Boolean.TRUE) {
			String cmdCode = node.getText("cmdCode");
			for(Map.Entry<String,Brw> entry : this.workingData.getMapBrw().entrySet()) {
				String sessId = entry.getKey();
				Brw brw = entry.getValue();
				if (cmdCode.equals(brw.getCmdCode())) {
					this.sendMessage(brw.getSession(), node.toString());
					System.out.printf(">>>>> [wsBrw.broadCast]: %s %s %s\n", sessId, cmdCode, node.toString());
				} else {
					System.out.printf(">>>>> [wsBrw.broadCast]: %s SKIP\n", sessId);
				}
			}
		}
	}
	
	public void sendMessage(Session session, String message) {
		//System.out.printf(">>>>> [wsBrw.sendMessage]: %s, message: %s\n", session.getId(), message);
		try {
			session.getBasicRemote().sendText(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
