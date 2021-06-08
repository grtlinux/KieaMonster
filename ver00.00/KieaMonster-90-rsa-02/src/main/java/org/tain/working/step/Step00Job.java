package org.tain.working.step;

import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.properties.ProjEnvParamProperties;
import org.tain.utils.CipherUtils;
import org.tain.utils.CurrentInfo;
import org.tain.utils.StringTools;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Step00Job {

	@Autowired
	private ProjEnvParamProperties projEnvParamProperties;
	
	private String imsiKeyPath = null;
	
	public void doing() throws Exception {
		log.info("KANG-20210405 {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			this.imsiKeyPath = this.projEnvParamProperties.getImsiKeyPath();
			log.info("KANG-20210405 -----> imsiKeyPath. {}", this.imsiKeyPath);
		}
		
		if (Boolean.TRUE) doingBase64DecodingOfHwPriKeyB64();
		if (!Boolean.TRUE) doingBase64DecodingOfHwPubKeyB64();
		
		log.info("");
	}
	
	private void doingBase64DecodingOfHwPriKeyB64() throws Exception {
		log.info("KANG-20210405 {} {}", CurrentInfo.get());
		
		String b64File = null;
		String binFile = null;
		if (Boolean.TRUE) {
			b64File = this.imsiKeyPath + File.separator + this.projEnvParamProperties.getHwPrikeyB64();
			binFile = this.imsiKeyPath + File.separator + this.projEnvParamProperties.getHwPrikeyBin();
		}
		
		if (Boolean.TRUE) {
			byte[] b64Data = StringTools.bytesFromFile(b64File);
			PrivateKey priKey = CipherUtils.getPrivateKeyFromBase64(b64Data);
			byte[] binData = priKey.getEncoded();
			StringTools.bytesToFile(binData, binFile);
			log.info("KANG-20210405 -----> {} -> {}", b64File, binFile);
			StringTools.printHex(b64Data);
			StringTools.printHex(binData);
		}
	}
	
	private void doingBase64DecodingOfHwPubKeyB64() throws Exception {
		log.info("KANG-20210405 {} {}", CurrentInfo.get());
		
		String b64File = null;
		String binFile = null;
		if (Boolean.TRUE) {
			b64File = this.imsiKeyPath + File.separator + this.projEnvParamProperties.getHwPubkeyB64();
			binFile = this.imsiKeyPath + File.separator + this.projEnvParamProperties.getHwPubkeyBin();
		}
		
		if (Boolean.TRUE) {
			byte[] b64Data = StringTools.bytesFromFile(b64File);
			PublicKey pubKey = CipherUtils.getPublicKeyFromBase64(b64Data);
			byte[] binData = pubKey.getEncoded();
			StringTools.bytesToFile(binData, binFile);
			log.info("KANG-20210405 -----> {} -> {}", b64File, binFile);
			StringTools.printHex(b64Data);
			StringTools.printHex(binData);
		}
	}
}
