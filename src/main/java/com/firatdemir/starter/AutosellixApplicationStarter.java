package com.firatdemir.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "com.firatdemir" })
@EntityScan(basePackages = { "com.firatdemir" })
@EnableJpaRepositories(basePackages = { "com.firatdemir" })
@SpringBootApplication
public class AutosellixApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(AutosellixApplicationStarter.class, args);
	}

}
