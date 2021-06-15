package org.tain.tasks.websocketclient;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;

import org.tain.data.WorkingData;

@ClientEndpoint
public class WebSocketClient {

	private WorkingData workingData;
	private ParsingRecvMsg parsingRecvMsg;
	
	public WebSocketClient(WorkingData workingData, ParsingRecvMsg parsingRecvMsg) {
		this.workingData = workingData;
		this.parsingRecvMsg = parsingRecvMsg;
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	@OnMessage
	public void onMessage(String recvMsg) {
		System.out.printf(">>>>> [OnMessage] (%s) message: %s\n", this.workingData.getName(), recvMsg);
		
		if (Boolean.TRUE) {
			this.parsingRecvMsg.parsing(recvMsg);
		}
	}
	
	@OnError
	public void onError(Throwable t) {
		System.out.printf(">>>>> [OnError] throwable: %s\n", t.getMessage());
	}
	
	@OnClose
	public void onClose() {
		System.out.printf(">>>>> [OnClose]\n");
	}
}
