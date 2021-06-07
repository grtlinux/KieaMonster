package org.tain.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tain.utils.StringTools;

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
	
	private String workingPath;
	private String configPath;
	
	private boolean step01Flag;
	private boolean step02Flag;
	private boolean step03Flag;
	private boolean step04Flag;
	private boolean step05Flag;
	private boolean step06Flag;
	private boolean step07Flag;
	private boolean step08Flag;
	private boolean step09Flag;
	private boolean step10Flag;
	private boolean step11Flag;
	private boolean step12Flag;
	private boolean step13Flag;
	private boolean step14Flag;
	private boolean step15Flag;
	
	@Bean
	public void init() throws Exception {
		this.todayPath = String.format("/%s", StringTools.getYYYYMMDD());
		
		this.workingPath = this.home + this.base + this.workPath + this.todayPath;
		this.configPath = this.home + this.base + this.workPath + this.confPath;
	}
}
