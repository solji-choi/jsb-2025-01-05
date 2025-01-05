package com.ll.jsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JsbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsbApplication.class, args);
	}

}
