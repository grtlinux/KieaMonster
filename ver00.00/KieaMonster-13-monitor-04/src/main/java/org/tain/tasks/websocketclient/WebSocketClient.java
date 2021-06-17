package org.tain.tasks.websocketclient;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;

import org.tain.data.WorkingData;
import org.tain.data.parser.ParsingOfBrowser;

@Deprecated
@ClientEndpoint
public class WebSocketClient {

	private WorkingData workingData;
	@SuppressWarnings("unused")
	private ParsingOfBrowser parsingOfMonitor;
	
	public WebSocketClient(WorkingData workingData, ParsingOfBrowser parsingOfMonitor) {
		this.workingData = workingData;
		this.parsingOfMonitor = parsingOfMonitor;
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	@OnMessage
	public void onMessage(String message) {
		System.out.printf(">>>>> [OnMessage] (%s) message: %s\n", this.workingData.getName(), message);
		
		if (Boolean.TRUE) {
			//this.parsingOfMonitor.parsing(message);
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
