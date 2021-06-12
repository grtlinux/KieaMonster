package org.tain.working.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "proj-env.param")
@Data
public class ProjEnvParam {

	private String basePath;
	private String custFile;
	private String prodFile;
	private String custProdFile;
}
