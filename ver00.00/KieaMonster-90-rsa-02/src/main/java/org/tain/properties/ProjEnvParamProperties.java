package org.tain.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "proj-env.param")
@Data
public class ProjEnvParamProperties {

	private String name;  // default
	
	private String home;
	private String base;
	private String workPath;
	private String confPath;
	private String todayPath;
	
	private String hwPrikeyBin;
	private String hwPrikeyB64;
	
	private String hwPubkeyBin;
	private String hwPubkeyB64;
	
	private String hwOtkBin;
	private String hwOtkEnc;
	private String hwOtkB64;
	
	private String moPubkeyBin;
	private String moPubkeyB64;
	
	private String moOtkBin;
	private String moOtkEnc;
	private String moOtkB64;
	
	private String dummy;  // null
}
