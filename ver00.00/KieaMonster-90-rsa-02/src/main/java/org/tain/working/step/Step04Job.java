package org.tain.working.step;

import java.io.File;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.properties.ProjEnvParam;
import org.tain.utils.CurrentInfo;
import org.tain.utils.StringTools;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Step04Job {

	@Autowired
	private ProjEnvParam projEnvParam;
	
	private String workingPath = null;
	
	public void doing() throws Exception {
		log.info("KANG-20210405 {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			this.workingPath = this.projEnvParam.getWorkingPath();
			log.info("KANG-20210405 -----> workingPath. {}", this.workingPath);
		}
		
		if (Boolean.TRUE) doingBase64HwPriKey();
		if (Boolean.TRUE) doingBase64HwPubKey();
		
		log.info("");
	}
	
	private void doingBase64HwPriKey() throws Exception {
		log.info("KANG-20210405 {} {}", CurrentInfo.get());
		
		String binFile = null;
		String b64File = null;
		if (Boolean.TRUE) {
			binFile = this.workingPath + File.separator + this.projEnvParam.getHwPrikeyBin();
			b64File = this.workingPath + File.separator + this.projEnvParam.getHwPrikeyB64();
		}
		
		if (Boolean.TRUE) {
			byte[] binData = StringTools.bytesFromFile(binFile);
			byte[] b64Data = Base64.getEncoder().encode(binData);
			StringTools.bytesToFile(b64Data, b64File);
			log.info("KANG-20210405 -----> {} -> {}", binFile, b64File);
		}
	}
	
	private void doingBase64HwPubKey() throws Exception {
		log.info("KANG-20210405 {} {}", CurrentInfo.get());
		
		String binFile = null;
		String b64File = null;
		if (Boolean.TRUE) {
			binFile = this.workingPath + File.separator + this.projEnvParam.getHwPubkeyBin();
			b64File = this.workingPath + File.separator + this.projEnvParam.getHwPubkeyB64();
		}
		
		if (Boolean.TRUE) {
			byte[] binData = StringTools.bytesFromFile(binFile);
			byte[] b64Data = Base64.getEncoder().encode(binData);
			StringTools.bytesToFile(b64Data, b64File);
			log.info("KANG-20210405 -----> {} -> {}", binFile, b64File);
		}
	}
}
