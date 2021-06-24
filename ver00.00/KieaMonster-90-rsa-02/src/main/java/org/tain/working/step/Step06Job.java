package org.tain.working.step;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.properties.ProjEnvParam;
import org.tain.utils.CurrentInfo;
import org.tain.utils.StringTools;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Step06Job {

	@Autowired
	private ProjEnvParam projEnvParam;
	
	private String imsiKeyPath = null;
	private String workingPath = null;
	
	public void doing() throws Exception {
		log.info("KANG-20210405 {} {}", CurrentInfo.get());
		log.info("KANG-20210405 -----> FI0001(1000): recv MO_PubKey.b64 <- MO");
		
		if (Boolean.TRUE) {
			this.imsiKeyPath = this.projEnvParam.getImsiKeyPath();
			this.workingPath = this.projEnvParam.getWorkingPath();
			log.info("KANG-20210405 -----> imsiKeyPath. {}", this.imsiKeyPath);
			log.info("KANG-20210405 -----> workingPath. {}", this.workingPath);
		}
		
		if (!Boolean.TRUE) doingImsi();  // TODO: to be comment in the success future.
		if (Boolean.TRUE) doingB64DecodingOfMoPubKeyB64();
		
		log.info("");
	}
	
	private void doingImsi() throws Exception {
		log.info("KANG-20210405 {} {}", CurrentInfo.get());
		
		Path srcFile = null;
		Path dstFile = null;
		if (Boolean.TRUE) {
			//srcFile = Paths.get(this.imsiKeyPath + File.separator + this.projEnvParam.getMoPubkeyB64());
			srcFile = Paths.get(this.workingPath + File.separator + this.projEnvParam.getHwPubkeyB64());
			dstFile = Paths.get(this.workingPath + File.separator + this.projEnvParam.getMoPubkeyB64());
			
			Files.copy(srcFile, dstFile, StandardCopyOption.REPLACE_EXISTING);
			log.info("KANG-20210405 -----> (IMSI) file copy. {} {}", srcFile, dstFile);
		}
	}
	
	private void doingB64DecodingOfMoPubKeyB64() throws Exception {
		log.info("KANG-20210405 {} {}", CurrentInfo.get());
		
		String b64File = null;
		String binFile = null;
		if (Boolean.TRUE) {
			b64File = this.workingPath + File.separator + this.projEnvParam.getMoPubkeyB64();
			binFile = this.workingPath + File.separator + this.projEnvParam.getMoPubkeyBin();
			log.info(">>>>> b64File. {}", b64File);
			log.info(">>>>> binFile. {}", binFile);
		}
		
		if (Boolean.TRUE) {
			byte[] b64Data = StringTools.bytesFromFile(b64File);
			byte[] binData = Base64.getMimeDecoder().decode(b64Data);
			StringTools.bytesToFile(binData, binFile);
			log.info("KANG-20210405 -----> {} -> {}", b64File, binFile);
		}
	}
}
