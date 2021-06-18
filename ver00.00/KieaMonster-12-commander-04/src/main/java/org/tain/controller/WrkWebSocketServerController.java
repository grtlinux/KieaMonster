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
public class WrkWebSocketServerController {

	@Autowired
	private WorkingData workingData;
	
	@Autowired
	private ParsingOfWorker parsingOfWorker;
	
	///////////////////////////////////////////////////////////////////////////
	//
	/*
	private Object getField(Object obj, Class<?> clazz, String fieldName) {
		for (;clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				Field field;
				field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
				return field.get(obj);
			} catch (Exception e) {
			}
		}
		return null;
	}
	
	private Object getFieldInstance(Object obj, String fieldPath) {
		String[] fields = fieldPath.split("#");
		for (String field : fields) {
			obj = getField(obj, obj.getClass(), field);
			if (obj == null) {
				return null;
			}
		}
		return obj;
	}
	
	// https://nowonbun.tistory.com/621?category=507117
	private Map<Session,EndpointConfig> configs = Collections.synchronizedMap(new HashMap<>());
	
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		System.out.printf(">>>>> [OnOpen] session.getId(): %s\n", session.getId());
		if (!configs.containsKey(session)) {
			configs.put(session, config);
		}
	}
	
	// string형식의 OPCODE가 1일 경우입니다.
	@OnMessage
	public String handleMessage(String message, Session session) throws IOException {
		if (configs.containsKey(session)) {
			EndpointConfig config = configs.get(session);
			HttpSession session2 = (HttpSession) config.getUserProperties().get(HttpSessionConfigurator.Session);
			System.out.println(">>>>> Session2: " + (String) session2.getAttribute("TestSession"));
		}
		
		System.out.println(message);
		return "echo - " + message;
	}
	
	// byte형식의 OPCODE가 2일 경우입니다.
	@OnMessage
	public byte[] handleMessage(byte[] message, Session session) {
		if (message.length <= 125) {
			String msg = new String(message);
			System.out.println(msg);
			msg = "echo - " + msg;
			return msg.getBytes();
		} else {
			String msg = new String(message);
			System.out.println(message.length);
			System.out.println(msg.substring(msg.length() - 10));
			return message;
		}
	}
	*/
	
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	@OnOpen
	public void onOpen(Session session) {
		if (!Boolean.TRUE) {
			//Async async = session.getAsyncRemote();
			//InetSocketAddress addr = (InetSocketAddress) getFieldInstance(async, "base#sos#socketWrapper#socket#sc#remoteAddress");
			//System.out.printf(">>>>> [OnOpen] session.getId(): %s, %s\n", session.getId(), addr);
			//System.out.printf(">>>>> [OnOpen] session.getId(): %s, %s\n", session.getId(), session.getUserProperties().get("javax.websocket.endpoint.remoteAddress"));
		}
		
		if (Boolean.TRUE) {
			// session의 timeout을 무제한으로 변경한다. 시간을 넣으면 ping, pong의 사양이 제대로 걸리지 않고, 어느 순간 갑자기 커넥션을 종료시켜버린다.
			session.setMaxIdleTimeout(0);
			// binary의 buffer size를 설정한다. 혹시라도 파일 업로드 서버를 만들고 싶다고 한다면 이 설정을 확인해야 한다.
			session.setMaxBinaryMessageBufferSize(1024 * 1024 * 10);
		}
		
		System.out.printf(">>>>> [OnOpen] session.getId(): %s\n", session.getId());
		this.workingData.getWrkSessions().add(session);
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		System.out.printf(">>>>> [OnMessage] session.getId(): %s, message: %s, name: %s\n", session.getId(), message, this.workingData.getName());
		if (Boolean.TRUE) {
			this.parsingOfWorker.parsing(message);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
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
		this.workingData.getWrkSessions().forEach(session -> {
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
