package org.tain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tain.working.Working;

@SpringBootApplication
public class Mybatis99Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Mybatis99Application.class, args);
	}

	@Autowired
	private Working working;
	
	@Override
	public void run(String... args) throws Exception {
		this.working.work();
	}
}
