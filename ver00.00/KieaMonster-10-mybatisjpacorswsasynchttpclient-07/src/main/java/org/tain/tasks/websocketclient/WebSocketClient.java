package org.tain.tasks.websocketclient;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;

import org.tain.data.WorkingData;

@ClientEndpoint
public class WebSocketClient {

	private WorkingData workingData;
	
	public WebSocketClient(WorkingData workingData) {
		this.workingData = workingData;
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	@OnMessage
	public void onMessage(String message) {
		System.out.printf(">>>>> [OnMessage] (%s) message: %s\n", this.workingData.getName(), message);
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
