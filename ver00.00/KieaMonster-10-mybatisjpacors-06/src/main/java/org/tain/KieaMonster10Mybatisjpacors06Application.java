package org.tain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tain.working.Work;

@SpringBootApplication
public class KieaMonster10Mybatisjpacors06Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KieaMonster10Mybatisjpacors06Application.class, args);
	}

	@Autowired
	private Work work;
	
	@Override
	public void run(String... args) throws Exception {
		if (Boolean.TRUE) this.work.working();
		
		if (!Boolean.TRUE) {
			System.exit(0);
		}
	}
}
