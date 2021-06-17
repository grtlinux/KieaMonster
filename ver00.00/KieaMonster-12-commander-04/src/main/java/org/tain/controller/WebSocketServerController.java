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
import org.tain.data.parser.ParsingOfWorker;

@Controller
@ServerEndpoint(value = "/wsWrk", configurator = CustomSpringConfig.class)
public class WebSocketServerController {

	@Autowired
	private WorkingData workingData;
	
	@Autowired
	private ParsingOfWorker parsingOfWorker;
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println(">>>>> [OnOpen] session.getId(): " + session.getId());
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		System.out.printf(">>>>> [OnMessage] session.getId(): %s, message: %s, name: %s\n", session.getId(), message, this.workingData.getName());
		if (Boolean.TRUE) {
			this.parsingOfWorker.parsing(message);
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
		
	}
	
	public void sendMessage(Session session, String message) {
		
	}
}
