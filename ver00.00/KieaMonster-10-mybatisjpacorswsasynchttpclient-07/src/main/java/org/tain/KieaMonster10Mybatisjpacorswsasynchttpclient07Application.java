package org.tain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tain.tools.properties.ProjEnvBase;
import org.tain.working.Work;

@SpringBootApplication
public class KieaMonster10Mybatisjpacorswsasynchttpclient07Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KieaMonster10Mybatisjpacorswsasynchttpclient07Application.class, args);
	}

	@Autowired
	private ProjEnvBase projEnvBase;
	
	@Autowired
	private Work work;
	
	@Override
	public void run(String... args) throws Exception {
		if (Boolean.TRUE) this.work.working();
		
		if (this.projEnvBase.isTestFlag()) {
			System.exit(0);
		}
	}
}
