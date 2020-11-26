package com.shinhaninvetment.opendart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class OpenDartApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenDartApplication.class, args);
	}

}
