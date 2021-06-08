package org.tain.working.step;

import org.springframework.stereotype.Component;
import org.tain.utils.CurrentInfo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Step08Job {

	public void doing() throws Exception {
		log.info("KANG-20210405 {} {}", CurrentInfo.get());
		log.info("KANG-20210405 -----> FI0071(1000:300:AF71): recv AF71 <- MO");
		
		
		log.info("");
	}
}
