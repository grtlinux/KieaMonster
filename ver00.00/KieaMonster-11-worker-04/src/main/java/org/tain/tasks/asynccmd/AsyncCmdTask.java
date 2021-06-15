package org.tain.tasks.asynccmd;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.tain.data.vo.Cmd;
import org.tain.utils.CurrentInfo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AsyncCmdTask {

	@Async(value = "async_0101")
	public void async_0101(Cmd cmd) throws Exception {
		log.info("KANG-20210615 >>>>> async_0101 START {} {}", cmd, CurrentInfo.get());
	}
}
