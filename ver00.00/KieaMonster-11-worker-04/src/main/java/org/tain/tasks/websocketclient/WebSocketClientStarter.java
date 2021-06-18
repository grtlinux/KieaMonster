package org.tain.tasks.websocketclient;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.tain.data.WorkingData;
import org.tain.data.parser.ParsingOfCommander;
import org.tain.tools.node.MonJsonNode;
import org.tain.tools.properties.ProjEnvUrl;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Sleep;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WebSocketClientStarter {

	@Autowired
	private ProjEnvUrl projEnvUrl;
	
	private Session session;
	
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private WorkingData workingData;
	
	@Autowired
	private ParsingOfCommander parsingOfCommander;
	
	@Async(value = "async_0102")
	public void async_0102(String param) throws Exception {
		log.info("KANG-20210615 >>>>> async_0102 START {} {}", param, CurrentInfo.get());
		
		if (Boolean.TRUE) {
			// try to connect to the websocket server
			Sleep.run(2 * 1000);
			for (int i=0; ; i++) {
				try {
					WebSocketClient webSocketClient = new WebSocketClient(this.workingData, this.parsingOfCommander);
					WebSocketContainer container = ContainerProvider.getWebSocketContainer();
					String wsUri = this.projEnvUrl.getWsWrkUri();  // ws://localhost:8092/v0.1/wsWrk
					this.session = container.connectToServer(webSocketClient, URI.create(wsUri));
					
					// couldn't clear queue, because of sendInfoMessage
					this.workingData.getQueueFromAsyncToCommander().clear();
					break;
				} catch (Exception e) {
					//e.printStackTrace();
					System.out.println(">>>>> connection failed. -> " + e.getMessage());
				}
				System.out.println(">>>>> try to connect again....." + i);
				Sleep.run(10 * 1000);
			}
			
			System.out.println(">>>>> Start WebSocketClient.....sessionId: " + this.session.getId());
		}
		
		if (Boolean.TRUE) {
			// send results to the commander
			try {
				while (true) {
					// get result from the queueSendResult
					MonJsonNode resultNode = this.workingData.getQueueFromAsyncToCommander().get();
					System.out.println(">>>>> async_0102 " + param + ": " + resultNode.toPrettyString());
					
					// send result
					this.sendMessage(resultNode.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.session.close();
			}
		}
		// retry to connect
		
		log.info("KANG-20210615 >>>>> async_0102 END   {} {}", param, CurrentInfo.get());
	}
	
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	public void sendMessage(String message) throws Exception {
		System.out.println("[sendMessage] message: " + message);
		this.session.getAsyncRemote().sendText(message);
	}
	
	public void close() throws Exception {
		this.session.close();
	}
}
