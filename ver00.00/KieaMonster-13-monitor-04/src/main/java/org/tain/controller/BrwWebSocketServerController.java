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
import org.tain.data.parser.ParsingOfBrowser;

@Controller
@ServerEndpoint(value = "/wsBrw", configurator = CustomSpringConfig.class)
public class BrwWebSocketServerController {

	@Autowired
	private WorkingData workingData;
	
	@Autowired
	private ParsingOfBrowser parsingOfBrowser;
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println(">>>>> [OnOpen] session.getId(): " + session.getId());
		this.workingData.getBrwSessions().add(session);
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		System.out.printf(">>>>> [OnMessage] session.getId(): %s, message: %s, name: %s\n", session.getId(), message, this.workingData.getName());
		if (Boolean.TRUE) {
			this.parsingOfBrowser.parsing(session, message);
		}
	}
	
	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println(">>>>> [OnError] session.getId(): " + session.getId());
		t.printStackTrace();
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println(">>>>> [OnClose] session.getId(): " + session.getId());
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public void broadCast(String message) {
		System.out.println(">>>>> [broadCast]: ");
		this.workingData.getBrwSessions().forEach(session -> {
			this.sendMessage(session, message);
		});
	}
	
	public void sendMessage(Session session, String message) {
		System.out.println(">>>>> [sendMessage]: " + session.getId());
		try {
			session.getBasicRemote().sendText(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
