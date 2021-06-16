package org.tain.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tain.tasks.websocketclient.WebSocketClientStarter;
import org.tain.utils.CurrentInfo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TaskStarter {

	@Autowired
	private WebSocketClientStarter webSocketClientStarter;
	
	@Bean
	public void starter() throws Exception {
		log.info("KANG-20210615 >>>>> START {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) this.webSocketClientStarter.async_0102("WS_CLIENT");
		
		log.info("KANG-20210615 >>>>> END   {} {}", CurrentInfo.get());
	}
}
