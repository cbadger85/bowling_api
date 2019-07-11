package com.charlesbadger.bowlingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.charlesbadger"})
public class BowlingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BowlingApiApplication.class, args);
	}

}
