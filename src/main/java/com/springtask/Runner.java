package com.springtask;

import com.springtask.content.StaticContent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner {

	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
		StaticContent.setStartTimeOfApp(System.currentTimeMillis());
	}
}
