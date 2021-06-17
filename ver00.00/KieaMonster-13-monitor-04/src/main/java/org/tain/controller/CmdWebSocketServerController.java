package org.tain.controller;

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
import org.tain.data.parser.ParsingOfCommander;

@Controller
@ServerEndpoint(value = "/wsCmd", configurator = CustomSpringConfig.class)
public class CmdWebSocketServerController {

	@Autowired
	private WorkingData workingData;
	
	@Autowired
	private ParsingOfCommander parsingOfCommander;
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println(">>>>> [wsCmd.OnOpen] session.getId(): " + session.getId());
		this.workingData.getCmdSessions().add(session);
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		//System.out.printf(">>>>> [wsCmd.OnMessage] session.getId(): %s, message: %s, name: %s\n", session.getId(), message, this.workingData.getName());
		System.out.printf(">>>>> [wsCmd.OnMessage] session.getId(): %s, message: %s\n", session.getId(), message);
		if (Boolean.TRUE) {
			this.parsingOfCommander.parsing(session, message);
		}
	}
	
	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println(">>>>> [wsCmd.OnError] session.getId(): " + session.getId());
		t.printStackTrace();
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println(">>>>> [wsCmd.OnClose] session.getId(): " + session.getId());
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public void broadCast(String message) {
		System.out.println(">>>>> [wsCmd.broadCast]: ");
		this.workingData.getCmdSessions().forEach(session -> {
			this.sendMessage(session, message);
		});
	}
	
	public void sendMessage(Session session, String message) {
		System.out.println(">>>>> [wsCmd.sendMessage]: " + session.getId());
		try {
			session.getBasicRemote().sendText(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
