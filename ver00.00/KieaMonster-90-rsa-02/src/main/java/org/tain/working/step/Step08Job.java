package org.tain.working.step;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.properties.ProjEnvParam;
import org.tain.utils.CurrentInfo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Step08Job {

	@Autowired
	private ProjEnvParam projEnvParam;
	
	private String imsiKeyPath = null;
	private String workingPath = null;
	
	public void doing() throws Exception {
		log.info("KANG-20210405 {} {}", CurrentInfo.get());
		log.info("KANG-20210405 -----> FI0071(1000:300:AF71): recv AF71 <- MO");
		
		if (Boolean.TRUE) {
			this.imsiKeyPath = this.projEnvParam.getImsiKeyPath();
			this.workingPath = this.projEnvParam.getWorkingPath();
			log.info("KANG-20210405 -----> imsiKeyPath. {}", this.imsiKeyPath);
			log.info("KANG-20210405 -----> workingPath. {}", this.workingPath);
		}
		
		if (Boolean.TRUE) doingImsi();  // TODO: to be comment in the success future.
		
		log.info("");
	}
	
	private void doingImsi() throws Exception {
		log.info("KANG-20210405 {} {}", CurrentInfo.get());
		
		Path srcFile = null;
		Path dstFile = null;
		if (Boolean.TRUE) {
			srcFile = Paths.get(this.imsiKeyPath + File.separator + this.projEnvParam.getMoAf71B64());
			dstFile = Paths.get(this.workingPath + File.separator + this.projEnvParam.getMoAf71B64());
			
			Files.copy(srcFile, dstFile, StandardCopyOption.REPLACE_EXISTING);
			log.info("KANG-20210405 -----> (IMSI) file copy. {} {}", srcFile, dstFile);
		}
	}
}
