package org.tain.tasks.websocketclient;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.tain.utils.CurrentInfo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WebSocketClientStarter {

	@Async(value = "async_0102")
	public void async_0102(String param) throws Exception {
		log.info("KANG-20210615 >>>>> async_0102 START {} {}", param, CurrentInfo.get());
	}
}
